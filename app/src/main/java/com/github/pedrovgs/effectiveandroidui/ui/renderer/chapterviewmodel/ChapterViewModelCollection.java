package com.github.pedrovgs.effectiveandroidui.ui.renderer.chapterviewmodel;

import com.github.pedrovgs.effectiveandroidui.ui.viewmodel.ChapterViewModel;
import com.pedrogomez.renderers.AdapteeCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * AdapteeCollection implementation for ChaptersViewModel.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class ChapterViewModelCollection implements AdapteeCollection<ChapterViewModel> {

  private final List<ChapterViewModel> chapters;

  public ChapterViewModelCollection() {
    this(new ArrayList<ChapterViewModel>());
  }

  public ChapterViewModelCollection(List<ChapterViewModel> chapters) {
    this.chapters = chapters;
  }

  @Override public int size() {
    return chapters.size();
  }

  @Override public ChapterViewModel get(int index) {
    return chapters.get(index);
  }

  @Override public void add(ChapterViewModel chapter) {
    chapters.add(chapter);
  }

  @Override public void remove(ChapterViewModel chapter) {
    chapters.remove(chapter);
  }

  @Override public void addAll(Collection<ChapterViewModel> chapters) {
    this.chapters.addAll(chapters);
  }

  @Override public void removeAll(Collection<ChapterViewModel> chapters) {
    this.chapters.removeAll(chapters);
  }

  public void clear() {
    chapters.clear();
  }
}
