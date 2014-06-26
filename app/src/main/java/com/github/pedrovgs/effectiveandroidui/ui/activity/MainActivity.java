/*
 * Copyright (C) 2014 Pedro Vicente Gómez Sánchez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.pedrovgs.effectiveandroidui.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.github.pedrovgs.effectiveandroidui.R;
import com.github.pedrovgs.effectiveandroidui.domain.tvshow.TvShow;
import com.github.pedrovgs.effectiveandroidui.ui.fragment.TvShowCatalogFragment;
import com.github.pedrovgs.effectiveandroidui.ui.fragment.TvShowDraggableFragment;
import com.github.pedrovgs.effectiveandroidui.ui.fragment.TvShowFragment;
import com.github.pedrovgs.effectiveandroidui.ui.presenter.TvShowUIModule;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;

/**
 * Core activity of this application. This activity receives the launch intent and works as core of
 * the sample application.
 *
 * Review how this activity uses fragments to decide how to implement navigation using the
 * Navigator
 * entity.
 */
public class MainActivity extends BaseActivity implements TvShowCatalogFragment.Listener {

  @Inject Navigator navigator;

  private TvShowDraggableFragment tvShowDraggableFragment;
  private TvShowFragment tvShowFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initializeTvShowFragment();
    initializeTvShowDraggableFragment();
  }

  @Override
  protected List<Object> getModules() {
    LinkedList<Object> modules = new LinkedList<Object>();
    modules.add(new TvShowUIModule());
    return modules;
  }

  /*
   * This method contains the key of the application navigation. If there are no fragments attached
   * we will launch TvShowActivity.
   *
   * If any fragment is visible we will load the TvShow.
   *
   */
  @Override public void onTvShowClicked(final TvShow tvShow) {
    if (canInteractWithFragments()) {
      showTvShowOnTvShowDraggableFragment(tvShow);
      showTvShowOnTvShowFragment(tvShow);
    } else {
      openTvShowActivity(tvShow.getTitle());
    }
  }

  private void initializeTvShowDraggableFragment() {
    tvShowDraggableFragment =
        (TvShowDraggableFragment) getSupportFragmentManager().findFragmentById(
            R.id.f_tv_show_draggable);
    /*
     * If both fragments are visible we have to disable saved instance state in draggable
     * fragment because there are different fragment configurations in activity_main.xml
     * when the device is in portrait or landscape. Review layout- directory to get more
     * information.
     */
    if (tvShowFragment != null && tvShowDraggableFragment != null) {
      tvShowDraggableFragment.disableSaveInstanceState();
    }
  }

  private void initializeTvShowFragment() {
    tvShowFragment = (TvShowFragment) getSupportFragmentManager().findFragmentById(R.id.f_tv_show);
  }

  /**
   * Method created to open TvShowActivity for Android 2.X versions. This method is going to use a
   * Navigator object to open TvShowActivity. This method could be inside a presenter or view
   * model, but to the sample we are going to use the Navigator object from this activity.
   *
   * Is possible to start an activity from a presenter or view model because we have a activity
   * scope module to provide the current activity context.
   *
   * @param tvShowId used to open TvShowActivity.
   */
  private void openTvShowActivity(final String tvShowId) {
    navigator.openTvShowActivity(tvShowId);
  }

  private boolean canInteractWithFragments() {
    return tvShowDraggableFragment != null || tvShowFragment != null;
  }

  private void showTvShowOnTvShowDraggableFragment(TvShow tvShow) {
    if (isFragmentAvailable(tvShowDraggableFragment)) {
      tvShowDraggableFragment.showTvShow(tvShow.getTitle());
    }
  }

  private void showTvShowOnTvShowFragment(TvShow tvShow) {
    if (isFragmentAvailable(tvShowFragment)) {
      tvShowFragment.showTvShow(tvShow.getTitle());
    }
  }

  /**
   * Check if the fragment is ready to be notified of a new TvShow loaded.
   *
   * @return true if the Fragment instance is not null and is attached.
   */
  private boolean isFragmentAvailable(Fragment fragment) {
    return fragment != null && fragment.isAdded();
  }
}
