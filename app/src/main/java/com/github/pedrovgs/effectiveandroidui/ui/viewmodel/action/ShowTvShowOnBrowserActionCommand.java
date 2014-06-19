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
