package com.github.pedrovgs.effectiveandroidui.domain.di;

import com.github.pedrovgs.effectiveandroidui.domain.tvshow.Catalog;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * @author Pedro Vicente Gómez Sánchez
 */
@Module(library = true)
public class TvShowsModule {

  @Provides @Singleton Catalog provideCatalog() {
    return new Catalog();
  }
}
