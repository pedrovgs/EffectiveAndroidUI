package com.github.pedrovgs.effectiveandroidui.ui.presenter;

import com.github.pedrovgs.effectiveandroidui.domain.GetTvShowById;
import com.github.pedrovgs.effectiveandroidui.domain.tvshow.ChapterCollection;
import com.github.pedrovgs.effectiveandroidui.domain.tvshow.TvShow;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Presenter created to show a TvShow.
 *
 * This is a sample of Model View Presenter pattern described in the talk Effective Android UI.
 *
 * We have attached the presenter to the Fragment lifecycle using method like initialize() resume()
 * and pause(). We are going to use this methods to connect our presenter with Android components
 * lifecycle.
 *
 * @author Pedro Vicente Gómez Sánchez
 */

@Singleton
public class TvShowPresenter extends Presenter {

  private final GetTvShowById getTvShowById;

  @Inject
  public TvShowPresenter(GetTvShowById getTvShowById) {
    this.getTvShowById = getTvShowById;
  }

  private View view;

  @Override public void initialize() {
    //Empty
  }

  @Override public void resume() {
    //Empty
  }

  @Override public void pause() {
    //Empty
  }

  public void setView(View view) {
    this.view = view;
  }

  public void loadTvShow(final String tvShowId) {
    view.hideEmptyCase();
    view.showLoading();
    getTvShowById.execute(tvShowId, new GetTvShowById.Callback() {
      @Override public void onTvShowLoaded(TvShow tvShow) {
        if (view.isReady()) {
          view.showFanArt(tvShow.getFanArt());
          view.showTvShowTitle(tvShow.getTitle().toUpperCase());
          view.showChapters(tvShow.getChapters());
          view.hideLoading();
          view.showTvShow();
        }
      }

      @Override public void onTvShowNotFound() {
        if (view.isReady()) {
          view.hideLoading();
          view.showEmptyCase();
          view.showTvShowNotFoundMessage();
        }
      }

      @Override public void onConnectionError() {
        if (view.isReady()) {
          view.hideLoading();
          view.showEmptyCase();
          view.showConnectionErrorMessage();
        }
      }
    });
  }

  /**
   * View interface created to abstract the view implementation used in this sample.
   */
  public interface View {

    void hideEmptyCase();

    void showLoading();

    void showFanArt(final String tvShowFanArtUrl);

    void showChapters(final ChapterCollection episodes);

    void hideLoading();

    void showEmptyCase();

    void showTvShowNotFoundMessage();

    void showConnectionErrorMessage();

    void showTvShow();

    void showTvShowTitle(String tvShowTitle);

    boolean isReady();
  }
}
