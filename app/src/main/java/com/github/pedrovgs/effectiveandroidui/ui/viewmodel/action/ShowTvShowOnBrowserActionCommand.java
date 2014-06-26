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
package com.github.pedrovgs.effectiveandroidui.ui.viewmodel.action;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.github.pedrovgs.effectiveandroidui.di.ActivityContext;
import javax.inject.Inject;

/**
 * ActionCommand implementation created to show the TvShow title when a TvShow is clicked.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class ShowTvShowOnBrowserActionCommand implements ActionCommand {

  private final Context context;

  private String tvShowUrl;

  @Inject
  public ShowTvShowOnBrowserActionCommand(@ActivityContext Context context) {
    this.context = context;
  }

  public void setTvShowUrl(String tvShowUrl) {
    this.tvShowUrl = tvShowUrl;
  }

  @Override public void execute() {
    if (tvShowUrl != null) {
      Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(tvShowUrl));
      context.startActivity(browserIntent);
    }
  }
}
