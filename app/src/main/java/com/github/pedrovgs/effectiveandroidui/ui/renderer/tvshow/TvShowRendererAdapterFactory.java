package com.github.pedrovgs.effectiveandroidui.ui.renderer.tvshow;

import android.view.LayoutInflater;
import com.github.pedrovgs.effectiveandroidui.domain.tvshow.TvShow;
import com.pedrogomez.renderers.RendererAdapter;
import javax.inject.Inject;

/**
 * Factory created to provide RendererAdapter<TvShow> implementations.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class TvShowRendererAdapterFactory {

  private final TvShowRendererBuilder rendererBuilder;
  private final LayoutInflater layoutInflater;

  @Inject
  public TvShowRendererAdapterFactory(TvShowRendererBuilder rendererBuilder,
      LayoutInflater layoutInflater) {
    this.rendererBuilder = rendererBuilder;
    this.layoutInflater = layoutInflater;
  }

  public RendererAdapter<TvShow> getTvShowRendererAdapter(final TvShowCollection tvShowCollection) {
    return new RendererAdapter<TvShow>(layoutInflater, rendererBuilder, tvShowCollection);
  }
}
