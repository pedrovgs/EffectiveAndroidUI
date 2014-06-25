/*
 * Copyright (C) 2014 Pedro Vicente Gómez Sánchez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.pedrovgs.effectiveandroidui.ui.presenter;

import com.github.pedrovgs.effectiveandroidui.domain.tvshow.Chapter;
import com.github.pedrovgs.effectiveandroidui.domain.tvshow.TvShow;
import com.github.pedrovgs.effectiveandroidui.ui.activity.MainActivity;
import com.github.pedrovgs.effectiveandroidui.ui.activity.TvShowActivity;
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
    injects = {
        MainActivity.class, TvShowCatalogFragment.class, TvShowDraggableFragment.class,
        TvShowFragment.class, TvShowActivity.class
    })
public final class TvShowUIModule {

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
