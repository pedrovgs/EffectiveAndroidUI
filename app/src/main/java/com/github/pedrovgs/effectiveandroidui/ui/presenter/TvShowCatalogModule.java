package com.github.pedrovgs.effectiveandroidui.ui.presenter;

import com.github.pedrovgs.effectiveandroidui.domain.tvshow.Chapter;
import com.github.pedrovgs.effectiveandroidui.domain.tvshow.TvShow;
import com.github.pedrovgs.effectiveandroidui.ui.fragment.TvShowCatalogFragment;
import com.github.pedrovgs.effectiveandroidui.ui.fragment.TvShowDraggableFragment;
import com.github.pedrovgs.effectiveandroidui.ui.fragment.TvShowFragment;
import com.github.pedrovgs.effectiveandroidui.ui.renderer.chapter.ChapterRenderer;
import com.github.pedrovgs.effectiveandroidui.ui.renderer.chapter.ChapterRendererBuilder;
import com.github.pedrovgs.effectiveandroidui.ui.renderer.chapterviewmodel.ChapterViewModelRenderer;
import com.github.pedrovgs.effectiveandroidui.ui.renderer.chapterviewmodel.ChapterViewModelRendererBuilder;
import com.github.pedrovgs.effectiveandroidui.ui.renderer.tvshow.TvShowRenderer;
import com.github.pedrovgs.effectiveandroidui.ui.renderer.tvshow.TvShowRendererBuilder;
import com.github.pedrovgs.effectiveandroidui.ui.viewmodel.ChapterViewModel;
import com.pedrogomez.renderers.Renderer;
import dagger.Module;
import dagger.Provides;
import java.util.LinkedList;

/**
 * Dagger module created to provide TvShows UI dependencies like RendererBuilders or presenters.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
@Module(complete = false,
    injects = { TvShowCatalogFragment.class, TvShowDraggableFragment.class, TvShowFragment.class })
public class TvShowCatalogModule {//Rename to TvShowUIModule

  @Provides TvShowRendererBuilder provideTvShowRendererBuilder(TvShowRenderer tvShowRenderer) {
    LinkedList<Renderer<TvShow>> renderers = new LinkedList<Renderer<TvShow>>();
    renderers.add(tvShowRenderer);
    return new TvShowRendererBuilder(renderers);
  }

  @Provides ChapterRendererBuilder provideChapterRendererBuilder(ChapterRenderer chapterRenderer) {
    LinkedList<Renderer<Chapter>> renderers = new LinkedList<Renderer<Chapter>>();
    renderers.add(chapterRenderer);
    return new ChapterRendererBuilder(renderers);
  }

  @Provides ChapterViewModelRendererBuilder provideChapterRendererBuilder(
      ChapterViewModelRenderer chapterRenderer) {
    LinkedList<Renderer<ChapterViewModel>> renderers = new LinkedList<Renderer<ChapterViewModel>>();
    renderers.add(chapterRenderer);
    return new ChapterViewModelRendererBuilder(renderers);
  }
}
