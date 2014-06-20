package com.github.pedrovgs.effectiveandroidui.ui.presenter;

import android.util.Log;
import com.github.pedrovgs.effectiveandroidui.domain.GetTvShows;
import com.github.pedrovgs.effectiveandroidui.domain.tvshow.TvShow;
import com.github.pedrovgs.effectiveandroidui.ui.renderer.tvshow.TvShowCollection;
import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Presenter created to show a list of videos inside a view.
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
public class TvShowCatalogPresenter extends Presenter {

  private GetTvShows getTvShowsInteractor;

  private View view;
  private TvShowCollection currentTvShowCollection;

  @Inject
  public TvShowCatalogPresenter(GetTvShows getTvShowsInteractor) {
    this.getTvShowsInteractor = getTvShowsInteractor;
  }

  public void setView(View view) {
    if (view == null) {
      throw new IllegalArgumentException("You can't set a null view");
    }
    this.view = view;
  }

  @Override
  public void initialize() {
    checkViewAlreadySetted();
    loadTvShows();
  }

  @Override
  public void resume() {
    //Empty
  }

  @Override
  public void pause() {
    //Empty
  }

  public void loadCatalog(final TvShowCollection tvShowCollection) {
    currentTvShowCollection = tvShowCollection;
    showTvShows(tvShowCollection.getAsList());
  }

  public void onTvShowThumbnailClicked(final TvShow tvShow) {
    view.showTvShow(tvShow);
  }

  public void onTvShowClicked(final TvShow tvShow) {
    view.showTvShowInfo(tvShow);
  }

  public TvShowCollection getCurrentTvShows() {
    return currentTvShowCollection;
  }

  /**
   * Use GetTvShows interactor to obtain a collection of videos and render it using the view
   * object setted previously. If the interactor returns an error the presenter will show an error
   * message and the empty case. In both cases, the progress bar visibility will be hidden.
   */
  private void loadTvShows() {
    getTvShowsInteractor.execute(new GetTvShows.Callback() {
      @Override public void onTvShowsLoaded(final Collection<TvShow> tvShows) {
        currentTvShowCollection = new TvShowCollection(tvShows);
        showTvShows(tvShows);
      }

      @Override public void onConnectionError() {
        if (view.isReady() && !view.isAlreadyLoaded()) {
          view.hideLoading();
          view.showConnectionErrorMessage();
          view.showEmptyCase();
          view.showDefaultTitle();
        }
      }
    });
  }

  private void showTvShows(Collection<TvShow> tvShows) {
    if (view.isReady()) {
      view.renderVideos(tvShows);
      view.hideLoading();
      view.updateTitleWithCountOfVideow(tvShows.size());
    }
  }

  private void checkViewAlreadySetted() {
    if (view == null) {
      throw new IllegalArgumentException("Remember to set a view for this presenter");
    }
  }

  /**
   * View interface created to abstract the view implementation used in this sample.
   */
  public interface View {

    void hideLoading();

    void renderVideos(final Collection<TvShow> tvShows);

    void updateTitleWithCountOfVideow(final int counter);

    void showConnectionErrorMessage();

    void showEmptyCase();

    void showDefaultTitle();

    void showTvShowInfo(TvShow tvShow);

    void showTvShow(TvShow tvShow);

    boolean isReady();

    boolean isAlreadyLoaded();
  }
}
