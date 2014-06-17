package com.github.pedrovgs.effectiveandroidui.ui.renderer.chapter;

import android.view.LayoutInflater;
import com.github.pedrovgs.effectiveandroidui.domain.tvshow.Chapter;
import com.pedrogomez.renderers.AdapteeCollection;
import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererAdapter;
import com.pedrogomez.renderers.RendererBuilder;

/**
 * RendererAdapter extension created to provide position information to each Renderer<Chapter>
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class ChapterRendererAdapter extends RendererAdapter<Chapter> {

  public ChapterRendererAdapter(LayoutInflater layoutInflater, RendererBuilder rendererBuilder,
      AdapteeCollection<Chapter> collection) {
    super(layoutInflater, rendererBuilder, collection);
  }

  @Override protected void updateRendererExtraValues(Chapter content, Renderer<Chapter> renderer,
      int position) {
    super.updateRendererExtraValues(content, renderer, position);
    ((ChapterRenderer) renderer).setPosition(position);
  }
}
