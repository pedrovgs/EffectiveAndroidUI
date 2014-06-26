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
 * Contains all the information related with a TvShow chapter.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class Chapter implements Serializable {
  private static final long serialVersionUID = 8799656473845972L;

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
