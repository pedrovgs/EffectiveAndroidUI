package com.github.pedrovgs.effectiveandroidui.domain.tvshow;

/**
 * Contains all the information related with a TvShow chapter.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class Chapter {

  private final String title;
  private final String publishDate;

  public Chapter(String title, String publishDate) {
    this.title = title;
    this.publishDate = publishDate;
  }

  /**
   * @return title associated to the EpisodeViewModel.
   */
  public String getTitle() {
    return title;
  }

  /**
   * @return publish date associated to the EpisodeViewModel
   */
  public String getPublishDate() {
    return publishDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Chapter)) return false;

    Chapter chapter = (Chapter) o;

    if (!title.equals(chapter.title)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    return title.hashCode();
  }
}
