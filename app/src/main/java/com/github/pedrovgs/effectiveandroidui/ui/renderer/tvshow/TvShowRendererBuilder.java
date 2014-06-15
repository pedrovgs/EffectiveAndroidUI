package com.github.pedrovgs.effectiveandroidui.ui.renderer.tvshow;

import com.github.pedrovgs.effectiveandroidui.domain.tvshow.TvShow;
import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;
import java.util.Collection;

/**
 * RendererBuilder extension created to provide Renderer<TvShow> implementations.
 *
 * If you want to lear more about how to use Renderers take a look to this project:
 * https://github.com/pedrovgs/Renderers
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class TvShowRendererBuilder extends RendererBuilder<TvShow> {

  public TvShowRendererBuilder(Collection<Renderer<TvShow>> prototypes) {
    super(prototypes);
  }

  @Override protected Class getPrototypeClass(TvShow tvShow) {
    return TvShowRenderer.class;
  }
}
