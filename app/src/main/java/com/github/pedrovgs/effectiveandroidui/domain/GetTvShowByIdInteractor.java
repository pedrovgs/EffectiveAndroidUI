package com.github.pedrovgs.effectiveandroidui.domain;

import com.github.pedrovgs.effectiveandroidui.domain.exception.TvShowNotFoundException;
import com.github.pedrovgs.effectiveandroidui.domain.tvshow.Catalog;
import com.github.pedrovgs.effectiveandroidui.domain.tvshow.TvShow;
import com.github.pedrovgs.effectiveandroidui.executor.Executor;
import com.github.pedrovgs.effectiveandroidui.executor.Interactor;
import com.github.pedrovgs.effectiveandroidui.executor.MainThread;
import com.github.pedrovgs.effectiveandroidui.util.RandomUtils;
import com.github.pedrovgs.effectiveandroidui.util.StringUtils;
import javax.inject.Inject;

/**
 * GetTvShowById implementation. This interactor will go out of the UI thread using the
 * executor, then will get a TvShow from the Catalog using the TvShow identifier  and will return
 * the result over the main thread using a callback and MainThread dependency.
 *
 * This application is a sample about how to work effectively on Android, this interactor will
 * return an error randomly.
 *
 * This interactor also contains a little delay to simulate a internal http request.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
class GetTvShowByIdInteractor implements Interactor, GetTvShowById {

  private static final int PERCENTAGE_OF_FAILS = 50;
  private static final long WAIT_TIME = 1500;

  private final Executor executor;
  private final MainThread mainThread;
  private final Catalog catalog;

  private String tvShowId;
  private Callback callback;

  @Inject GetTvShowByIdInteractor(Executor executor, MainThread mainThread, Catalog catalog) {
    this.executor = executor;
    this.mainThread = mainThread;
    this.catalog = catalog;
  }

  @Override public void execute(final String tvShowId, final Callback callback) {
    validateArguments(callback, tvShowId);
    this.callback = callback;
    this.tvShowId = tvShowId;
    this.executor.run(this);
  }

  @Override public void run() {
    waitToDoThisSampleMoreInteresting();

    if (haveToShowError()) {
      notifyConnectionError();
    } else {
      searchTvShow();
    }
  }

  /**
   * To simulate a we are getting the TvShows data from internet we are going to force a 1.5
   * seconds
   * delay using Thread.sleep.
   */
  private void waitToDoThisSampleMoreInteresting() {
    try {
      Thread.sleep(WAIT_TIME);
    } catch (InterruptedException e) {
      //Empty
    }
  }

  private boolean haveToShowError() {
    return RandomUtils.percent(PERCENTAGE_OF_FAILS);
  }

  private void searchTvShow() {
    TvShow tvShow = null;
    try {
      tvShow = this.catalog.getTvShowById(tvShowId);
    } catch (TvShowNotFoundException e) {
      notifyTvShowNotFound();
    }
    notifyTvShowFound(tvShow);
  }

  private void validateArguments(Callback callback, String tvShowId) {
    if (StringUtils.isNullOrEmpty(tvShowId)) {
      throw new IllegalArgumentException("TvShowId parameter can't be null");
    }
    if (callback == null) {
      throw new IllegalArgumentException("Callback parameter can't be null");
    }
  }

  private void notifyConnectionError() {
    mainThread.post(new Runnable() {
      @Override public void run() {
        callback.onConnectionError();
      }
    });
  }

  private void notifyTvShowFound(final TvShow tvShow) {
    mainThread.post(new Runnable() {
      @Override public void run() {
        callback.onTvShowLoaded(tvShow);
      }
    });
  }

  private void notifyTvShowNotFound() {
    mainThread.post(new Runnable() {
      @Override public void run() {
        callback.onTvShowNotFound();
      }
    });
  }
}
