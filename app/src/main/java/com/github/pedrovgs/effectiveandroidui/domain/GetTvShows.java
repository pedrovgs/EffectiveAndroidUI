package com.github.pedrovgs.effectiveandroidui.domain;

import com.github.pedrovgs.effectiveandroidui.domain.tvshow.TvShow;
import java.util.Collection;

/**
 * Returns every available TvShow in the system.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public interface GetTvShows {

  public interface Callback {
    void onTvShowsLoaded(final Collection<TvShow> tvShows);

    void onConnectionError();
  }

  void execute(Callback callback);
}
