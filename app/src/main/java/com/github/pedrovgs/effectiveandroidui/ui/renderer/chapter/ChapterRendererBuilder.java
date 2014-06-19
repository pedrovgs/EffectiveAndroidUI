package com.github.pedrovgs.effectiveandroidui.ui.renderer.chapter;

import com.github.pedrovgs.effectiveandroidui.domain.tvshow.Chapter;
import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;
import java.util.Collection;

/**
 * RendererBuilder extension created to provide Renderer<Chapter> implementations.
 *
 * If you want to lear more about how to use Renderers take a look to this project:
 * https://github.com/pedrovgs/Renderers
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class ChapterRendererBuilder extends RendererBuilder<Chapter> {

  public ChapterRendererBuilder(Collection<Renderer<Chapter>> prototypes) {
    super(prototypes);
  }

  @Override protected Class getPrototypeClass(Chapter content) {
    return ChapterRenderer.class;
  }
}
