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

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.github.pedrovgs.effectiveandroidui.R;
import com.github.pedrovgs.effectiveandroidui.ui.fragment.TvShowFragment;
import com.github.pedrovgs.effectiveandroidui.ui.presenter.TvShowUIModule;
import com.github.pedrovgs.effectiveandroidui.util.StringUtils;
import java.util.LinkedList;
import java.util.List;

/**
 * Activity created to show a TvShow using TvShowFragment. This activity is going to be launched
 * only in Android 2.X versions.
 *
 * This activity has to be launched using a tv show id as extra or will throw an exception.
 *
 * This Activity will implement two good practices:
 *
 * - Implement a method to create the intent needed to start this activity.
 * - This activity will be thrown from Navigator class used in TvShowCatalogPresenter instead of
 * start the activity from other activity.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class TvShowActivity extends BaseActivity {

  private static final String EXTRA_TV_SHOW_ID = "extra_tv_show_id";

  private String tvShowId;

  /**
   * Generates the intent neede by the client code to launch this activity. This method is a sample
   * of who to avoid duplicate this code by all the application.
   */
  public static Intent getLaunchIntent(final Context context, final String tvShowId) {
    if (StringUtils.isNullOrEmpty(tvShowId)) {
      throwIllegalArgumentException();
    }
    Intent intent = new Intent(context, TvShowActivity.class);
    return intent.putExtra(EXTRA_TV_SHOW_ID, tvShowId);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_tv_show);
    mapExtras();
    initializeFragment();
  }

  @Override protected List<Object> getModules() {
    List<Object> modules = new LinkedList<Object>();
    modules.add(new TvShowUIModule());
    return modules;
  }

  /**
   * As TvShowId is mandatory if there is no an extra inside the bundle that launches this activity
   * we are going to throw a new IllegalArgumentException.
   */
  private void mapExtras() {
    Bundle extras = getIntent().getExtras();
    if (extras == null) {
      throwIllegalArgumentException();
    }
    tvShowId = extras.getString(EXTRA_TV_SHOW_ID);
    if (StringUtils.isNullOrEmpty(tvShowId)) {
      throwIllegalArgumentException();
    }
  }

  /**
   * Propagates the tv show identifier to the fragment.
   */
  private void initializeFragment() {
    TvShowFragment tvShowFragment =
        (TvShowFragment) getSupportFragmentManager().findFragmentById(R.id.f_tv_show);
    tvShowFragment.showTvShow(tvShowId);
  }

  private static void throwIllegalArgumentException() {
    throw new IllegalArgumentException(
        "TvShowActivity has to be launched using a TvShow identifier as extra");
  }
}
