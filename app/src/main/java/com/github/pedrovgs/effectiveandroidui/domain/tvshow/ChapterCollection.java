package com.github.pedrovgs.effectiveandroidui.domain.tvshow;

import java.util.LinkedHashSet;
import java.util.List;

/**
 * Collection of chapters. Contains all the chapters information for each TvShow. This
 * implementation is based on a LinkedHashSet.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class ChapterCollection {

  private final LinkedHashSet<Chapter> chapters;

  public ChapterCollection() {
    this.chapters = new LinkedHashSet<Chapter>();
  }

  public List<Chapter> getChapters() {
    return (List<Chapter>) chapters.clone();
  }

  public void add(Chapter chapter) {
    this.chapters.add(chapter);
  }
}
