package com.github.pedrovgs.effectiveandroidui.domain;

import com.github.pedrovgs.effectiveandroidui.domain.tvshow.Catalog;
import com.github.pedrovgs.effectiveandroidui.domain.tvshow.TvShow;
import com.github.pedrovgs.effectiveandroidui.executor.Executor;
import com.github.pedrovgs.effectiveandroidui.executor.Interactor;
import com.github.pedrovgs.effectiveandroidui.executor.MainThread;
import com.github.pedrovgs.effectiveandroidui.util.RandomUtils;
import java.util.Collection;
import javax.inject.Inject;

/**
 * GetTvShows interactor implementation. This interactor will go out of the UI thread using the
 * executor, then will get a list of TvShows from the Catalog and will return the result over the
 * main thread using a callback and MainThread dependency.
 *
 * This application is a sample about how to work effectively on Android, this interactor will
 * return an error randomly.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
class GetTvShowsInteractor implements Interactor, GetTvShows {

  private static final int PERCENTAGE_OF_FAILS = 50;
  public static final int WAIT_TIME = 1500;

  private final Catalog catalog;
  private final Executor executor;
  private final MainThread mainThread;

  private Callback callback;

  @Inject GetTvShowsInteractor(Catalog catalog, Executor executor, MainThread mainThread) {
    this.catalog = catalog;
    this.executor = executor;
    this.mainThread = mainThread;
  }

  @Override public void execute(Callback callback) {
    if (callback == null) {
      throw new IllegalArgumentException(
          "Callback can't be null, the client of this interactor needs to get the response in the callback");
    }
    this.callback = callback;
    this.executor.run(this);
  }

  @Override public void run() {
    waitToDoThisSampleMoreInteresting();

    if (hasToShowError()) {
      notifyError();
    } else {
      Collection<TvShow> tvShows = catalog.getTvShows();
      nofityTvShowsLoaded(tvShows);
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

  private boolean hasToShowError() {
    return RandomUtils.percent(PERCENTAGE_OF_FAILS);
  }

  private void notifyError() {
    mainThread.post(new Runnable() {
      @Override public void run() {
        callback.onConnectionError();
      }
    });
  }

  private void nofityTvShowsLoaded(final Collection<TvShow> tvShows) {
    mainThread.post(new Runnable() {
      @Override public void run() {
        callback.onTvShowsLoaded(tvShows);
      }
    });
  }
}
