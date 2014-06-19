package com.github.pedrovgs.effectiveandroidui.ui.viewmodel;

import com.github.pedrovgs.effectiveandroidui.domain.tvshow.Chapter;

/**
 * ViewModel crated to represent a Chapter from the presentation point of view.
 *
 * This class could be a interface implementation if the ChapterViewModel has more than one
 * implementation.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class ChapterViewModel {

  private final Chapter chapter;

  public ChapterViewModel(Chapter chapter) {
    this.chapter = chapter;
  }

  public String getTitle() {
    return chapter.getTitle();
  }

  public String getPublishDate() {
    return chapter.getPublishDate();
  }
}
