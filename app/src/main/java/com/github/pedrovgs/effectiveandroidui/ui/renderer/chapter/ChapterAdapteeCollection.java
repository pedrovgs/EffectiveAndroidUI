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
package com.github.pedrovgs.effectiveandroidui.ui.renderer.chapter;

import com.github.pedrovgs.effectiveandroidui.domain.tvshow.Chapter;
import com.pedrogomez.renderers.AdapteeCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * AdapteeCollection implementation for Chapters.
 *
 * I've changed the name of this collection form ChapterCollection to ChapterAdapteeCollection
 * because there is a name collision.
 *
 * If you want to lear more about how to use Renderers take a look to this project:
 * https://github.com/pedrovgs/Renderers.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class ChapterAdapteeCollection implements AdapteeCollection<Chapter> {

  private final List<Chapter> chapters;

  public ChapterAdapteeCollection() {
    this(new ArrayList<Chapter>());
  }

  public ChapterAdapteeCollection(List<Chapter> chapters) {
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

  public void clear() {
    chapters.clear();
  }
}
