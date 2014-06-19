package com.github.pedrovgs.effectiveandroidui.ui.renderer.chapterviewmodel;

import com.github.pedrovgs.effectiveandroidui.ui.viewmodel.ChapterViewModel;
import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;
import java.util.Collection;

/**
 * RendererBuilder extension created to provide Renderer<ChapterViewModel> implementations.
 *
 * If you want to lear more about how to use Renderers take a look to this project:
 * https://github.com/pedrovgs/Renderers
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class ChapterViewModelRendererBuilder extends RendererBuilder<ChapterViewModel> {

  public ChapterViewModelRendererBuilder(Collection<Renderer<ChapterViewModel>> prototypes) {
    super(prototypes);
  }

  @Override protected Class getPrototypeClass(ChapterViewModel content) {
    return ChapterViewModelRenderer.class;
  }
}
