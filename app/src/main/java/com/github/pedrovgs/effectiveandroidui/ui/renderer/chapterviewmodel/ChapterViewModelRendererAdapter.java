package com.github.pedrovgs.effectiveandroidui.ui.renderer.chapterviewmodel;

import android.view.LayoutInflater;
import com.github.pedrovgs.effectiveandroidui.ui.viewmodel.ChapterViewModel;
import com.pedrogomez.renderers.AdapteeCollection;
import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererAdapter;
import com.pedrogomez.renderers.RendererBuilder;

/**
 * RendererAdapter extension created to provide position information to each
 * Renderer<ChapterViewModel>
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class ChapterViewModelRendererAdapter extends RendererAdapter<ChapterViewModel> {

  public ChapterViewModelRendererAdapter(LayoutInflater layoutInflater,
      RendererBuilder rendererBuilder, AdapteeCollection<ChapterViewModel> collection) {
    super(layoutInflater, rendererBuilder, collection);
  }

  @Override protected void updateRendererExtraValues(ChapterViewModel content,
      Renderer<ChapterViewModel> renderer, int position) {
    super.updateRendererExtraValues(content, renderer, position);
    ((ChapterViewModelRenderer) renderer).setPosition(position);
  }
}
