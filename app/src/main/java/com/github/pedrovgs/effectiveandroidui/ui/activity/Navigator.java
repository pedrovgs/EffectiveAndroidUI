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
import com.github.pedrovgs.effectiveandroidui.di.ActivityContext;
import javax.inject.Inject;

/**
 * Class created to handle all the navigation between activities. This class knows how to open
 * every
 * activity in the application and provides to the client code different methods to start
 * activities
 * with the information needed.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class Navigator {

  private final Context context;

  @Inject
  public Navigator(@ActivityContext Context context) {
    this.context = context;
  }

  /**
   * Open TvShowActivity using a tvShowId.
   */
  public void openTvShowActivity(final String tvShowId) {
    Intent intent = TvShowActivity.getLaunchIntent(context, tvShowId);
    startActivity(intent);
  }

  private void startActivity(Intent intent) {
    context.startActivity(intent);
  }
}
