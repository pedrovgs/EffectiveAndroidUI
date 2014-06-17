package com.github.pedrovgs.effectiveandroidui.ui.renderer.chapter;

import com.github.pedrovgs.effectiveandroidui.domain.tvshow.Chapter;
import com.pedrogomez.renderers.AdapteeCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * AdapteeCollection implementation for Chapters.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class ChapterCollection implements AdapteeCollection<Chapter> {

  private final List<Chapter> chapters;

  public ChapterCollection() {
    this(new ArrayList<Chapter>());
  }

  public ChapterCollection(List<Chapter> chapters) {
    this.chapters = chapters;
  }

  @Override public int size() {
    return chapters.size();
  }

  @Override public Chapter get(int index) {
    return chapters.get(index);
  }

  @Override public void add(Chapter chapter) {
    chapters.add(chapter);
  }

  @Override public void remove(Chapter chapter) {
    chapters.remove(chapter);
  }

  @Override public void addAll(Collection<Chapter> chapters) {
    this.chapters.addAll(chapters);
  }

  @Override public void removeAll(Collection<Chapter> chapters) {
    this.chapters.removeAll(chapters);
  }
}
