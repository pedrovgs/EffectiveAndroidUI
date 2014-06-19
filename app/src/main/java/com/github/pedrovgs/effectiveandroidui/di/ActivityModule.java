package com.github.pedrovgs.effectiveandroidui.di;

import android.app.Activity;
import android.content.Context;
import dagger.Module;
import dagger.Provides;

/**
 * @author Pedro Vicente Gómez Sánchez
 */
@Module(library = true)
public final class ActivityModule {

  private final Activity activity;

  public ActivityModule(Activity activity) {
    this.activity = activity;
  }

  @ActivityContext @Provides Context provideActivityContext() {
    return activity;
  }
}
