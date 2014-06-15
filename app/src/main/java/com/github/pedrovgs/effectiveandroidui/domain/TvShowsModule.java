package com.github.pedrovgs.effectiveandroidui.domain;

import com.github.pedrovgs.effectiveandroidui.domain.tvshow.Catalog;
import com.github.pedrovgs.effectiveandroidui.executor.ExecutorModule;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * @author Pedro Vicente Gómez Sánchez
 */
@Module(library = true, includes = ExecutorModule.class)
public class TvShowsModule {

  @Provides @Singleton Catalog provideCatalog() {
    return new Catalog();
  }

  @Provides GetTvShows provideGetTvShowsInteractor(GetTvShowsInteractor interactor) {
    return interactor;
  }

  @Provides GetTvShowById provideGetTvShowbyIdInteractor(GetTvShowByIdInteractor interactor) {
    return interactor;
  }
}
