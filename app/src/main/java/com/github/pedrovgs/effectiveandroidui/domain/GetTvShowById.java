package com.github.pedrovgs.effectiveandroidui.domain;

import com.github.pedrovgs.effectiveandroidui.domain.tvshow.TvShow;

/**
 * Get a TvShow given a TvShow identifier.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public interface GetTvShowById {

  public interface Callback {
    void onTvShowLoaded(final TvShow tvShow);

    void onTvShowNotFound();

    void onConnectionError();
  }

  void execute(final String tvShowId, final Callback callback);
}
