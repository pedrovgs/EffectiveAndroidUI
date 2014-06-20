package com.github.pedrovgs.effectiveandroidui.di;

import android.content.Context;
import android.view.LayoutInflater;
import com.github.pedrovgs.effectiveandroidui.TvShowsApplication;
import com.github.pedrovgs.effectiveandroidui.domain.TvShowsModule;
import com.github.pedrovgs.effectiveandroidui.executor.ExecutorModule;
import dagger.Module;
import dagger.Provides;

/**
 * Dagger module created to work as junction of every module with an application scope.
 *
 * @author Pedro Vicente Gómez Sánchez
 */

@Module(
    includes = {
        ExecutorModule.class, TvShowsModule.class,
    },
    injects = {
        TvShowsApplication.class
    }, library = true)
public final class RootModule {

  private final Context context;

  public RootModule(Context context) {
    this.context = context;
  }

  @Provides Context provideApplicationContext() {
    return context;
  }

  @Provides LayoutInflater provideLayoutInflater() {
    return LayoutInflater.from(context);
  }
}
