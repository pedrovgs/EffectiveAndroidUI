package com.github.pedrovgs.effectiveandroidui.ui.renderer.chapter;

import android.view.LayoutInflater;
import com.github.pedrovgs.effectiveandroidui.domain.tvshow.Chapter;
import com.pedrogomez.renderers.RendererAdapter;
import javax.inject.Inject;

/**
 * Factory created to provide RendererAdapter<Chapter> implementations.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class ChapterRendererAdapterFactory {

  private final ChapterRendererBuilder rendererBuilder;
  private final LayoutInflater layoutInflater;

  @Inject
  public ChapterRendererAdapterFactory(ChapterRendererBuilder rendererBuilder,
      LayoutInflater layoutInflater) {
    this.rendererBuilder = rendererBuilder;
    this.layoutInflater = layoutInflater;
  }

  public RendererAdapter<Chapter> getChapterRendererAdapter(
      final ChapterAdapteeCollection chapterCollection) {
    return new ChapterRendererAdapter(layoutInflater, rendererBuilder, chapterCollection);
  }
}
