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
package com.github.pedrovgs.effectiveandroidui.domain.tvshow;

import java.io.Serializable;

/**
 * Contains all the information related with a TvShow.
 *
 * Title field works as TvShow identifier because for the sample we don't have a unique identifier
 * ready to be used.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class TvShow implements Serializable {
  private static final long serialVersionUID = 8799656478674716638L;

  private final String title;
  private final String poster;
  private final String fanArt;
  private final int numberOfSeasons;
  private final ChapterCollection episodes;

  public TvShow(String title, String poster, String fanArt, int numberOfSeasons) {
    this.title = title;
    this.poster = poster;
    this.fanArt = fanArt;
    this.numberOfSeasons = numberOfSeasons;
    this.episodes = new ChapterCollection();
  }

  /**
   * Add an episode to the tvShowViewModel.
   */
  public void addEpisode(Chapter chapterViewModel) {
    episodes.add(chapterViewModel);
  }

  /**
   * @return the tv show title.
   */
  public String getTitle() {
    return title;
  }

  /**
   * @return the tv show poster.
   */
  public String getPoster() {
    return poster;
  }

  /**
   * @return the tv show fan art.
   */
  public String getFanArt() {
    return fanArt;
  }

  /**
   * @return the tv show number of seasons.
   */
  public int getNumberOfSeasons() {
    return numberOfSeasons;
  }

  /**
   * @return the tv show ChapterCollection.
   */
  public ChapterCollection getChapters() {
    return episodes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof TvShow)) return false;

    TvShow tvShow = (TvShow) o;

    if (!title.equals(tvShow.title)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    return title.hashCode();
  }
}
