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
