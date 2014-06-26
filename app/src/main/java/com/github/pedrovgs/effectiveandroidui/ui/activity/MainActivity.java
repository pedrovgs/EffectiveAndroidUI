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
import com.github.pedrovgs.effectiveandroidui.domain.GetTvShowById;
import com.github.pedrovgs.effectiveandroidui.domain.GetTvShows;
import com.github.pedrovgs.effectiveandroidui.domain.tvshow.TvShow;
import com.github.pedrovgs.effectiveandroidui.ui.fragment.TvShowCatalogFragment;
import com.github.pedrovgs.effectiveandroidui.ui.fragment.TvShowDraggableFragment;
import com.github.pedrovgs.effectiveandroidui.ui.fragment.TvShowFragment;
import com.github.pedrovgs.effectiveandroidui.ui.presenter.TvShowUIModule;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;

public class MainActivity extends BaseActivity implements TvShowCatalogFragment.Listener {

  @Inject GetTvShows getTvShows;
  @Inject GetTvShowById getTvShowsById;
  @Inject Navigator navigator;

  private TvShowDraggableFragment tvShowDraggableFragment;
  private TvShowFragment tvShowFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    tvShowDraggableFragment =
        (TvShowDraggableFragment) getSupportFragmentManager().findFragmentById(
            R.id.f_tv_show_draggable);
    tvShowFragment = (TvShowFragment) getSupportFragmentManager().findFragmentById(R.id.f_tv_show);
    if (tvShowFragment != null && tvShowDraggableFragment != null) {
      tvShowDraggableFragment.disableSaveInstanceState();
    }
  }

  @Override
  protected List<Object> getModules() {
    LinkedList<Object> modules = new LinkedList<Object>();
    modules.add(new TvShowUIModule());
    return modules;
  }

  @Override public void onTvShowClicked(final TvShow tvShow) {
    if (canInteractWithFragments()) {
      showTvShowOnTvShowDraggableFragment(tvShow);
      showTvShowOnTvShowFragment(tvShow);
    } else {
      openTvShowActivity(tvShow.getTitle());
    }
  }

  /**
   * Method created to open TvShowActivity for Android 2.X versions. This method is going to use a
   * Navigator object to open TvShowActivity. This method could be inside a presenter or view
   * model,
   * but to the sample we are going to use the Navigator object from this activity.
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

  private boolean isFragmentAvailable(Fragment fragment) {
    return fragment != null;
  }
}
