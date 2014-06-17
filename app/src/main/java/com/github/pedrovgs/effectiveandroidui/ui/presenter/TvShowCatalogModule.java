package com.github.pedrovgs.effectiveandroidui.ui.presenter;

import com.github.pedrovgs.effectiveandroidui.domain.tvshow.TvShow;
import com.github.pedrovgs.effectiveandroidui.ui.fragment.TvShowCatalogFragment;
import com.github.pedrovgs.effectiveandroidui.ui.fragment.TvShowDraggableFragment;
import com.github.pedrovgs.effectiveandroidui.ui.renderer.tvshow.TvShowRenderer;
import com.github.pedrovgs.effectiveandroidui.ui.renderer.tvshow.TvShowRendererBuilder;
import com.pedrogomez.renderers.Renderer;
import dagger.Module;
import dagger.Provides;
import java.util.LinkedList;

/**
 * Dagger module created to provide TvShows UI dependencies like TvShowCatalogPresenter.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
@Module(complete = false, injects = { TvShowCatalogFragment.class, TvShowDraggableFragment.class })
public class TvShowCatalogModule {

  @Provides TvShowRendererBuilder provideTvShowRendererBuilder(TvShowRenderer tvShowRenderer) {
    LinkedList<Renderer<TvShow>> renderers = new LinkedList<Renderer<TvShow>>();
    renderers.add(tvShowRenderer);
    return new TvShowRendererBuilder(renderers);
  }
}
