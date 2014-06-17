package com.github.pedrovgs.effectiveandroidui.ui.renderer.tvshow;

import com.github.pedrovgs.effectiveandroidui.domain.tvshow.TvShow;
import com.pedrogomez.renderers.AdapteeCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * AdapteeCollection implementation for TvShow.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class TvShowCollection implements AdapteeCollection<TvShow> {

  private final List<TvShow> tvShows;

  public TvShowCollection() {
    this(new ArrayList<TvShow>());
  }

  public TvShowCollection(List<TvShow> tvShows) {
    this.tvShows = tvShows;
  }

  @Override public int size() {
    return tvShows.size();
  }

  @Override public TvShow get(int index) {
    return tvShows.get(index);
  }

  @Override public void add(TvShow tvShow) {
    tvShows.add(tvShow);
  }

  @Override public void remove(TvShow tvShow) {
    tvShows.remove(tvShow);
  }

  @Override public void addAll(Collection<TvShow> tvShows) {
    this.tvShows.addAll(tvShows);
  }

  @Override public void removeAll(Collection<TvShow> tvShows) {
    this.tvShows.addAll(tvShows);
  }

  public void clear() {
    tvShows.clear();
  }
}
