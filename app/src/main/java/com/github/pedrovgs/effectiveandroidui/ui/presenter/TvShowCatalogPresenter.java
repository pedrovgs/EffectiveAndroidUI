package com.github.pedrovgs.effectiveandroidui.ui.presenter;

import com.github.pedrovgs.effectiveandroidui.domain.GetTvShows;
import com.github.pedrovgs.effectiveandroidui.domain.tvshow.TvShow;
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
public class TvShowCatalogPresenter {

  private GetTvShows getTvShowsInteractor;

  private View view;

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

  /**
   * Called when the presenter is initialized, this method represents the start of the presenter
   * lifecycle.
   */
  public void initialize() {
    checkViewAlreadySetted();
    loadVideos();
  }

  /**
   * Called when the presenter is resumed. After the initialization and when the presenter comes
   * from a pause state.
   */
  public void resume() {
    checkViewAlreadySetted();
    //Empty
  }

  /**
   * Called when the presenter is paused.
   */
  public void pause() {
    //Empty
  }

  /**
   * Use GetTvShows interactor to obtain a collection of videos and render it using the view
   * object setted previously. If the interactor returns an error the presenter will show an error
   * message and the empty case. In both cases, the progress bar visibility will be hidden.
   */
  private void loadVideos() {
    getTvShowsInteractor.execute(new GetTvShows.Callback() {
      @Override public void onTvShowsLoaded(Collection<TvShow> tvShows) {
        view.renderVideos(tvShows);
        view.hideLoading();
        view.updateTitleWithCountOfVideow(tvShows.size());
      }

      @Override public void onConnectionError() {
        view.hideLoading();
        view.showConnectionErrorMessage();
        view.showEmptyCase();
        view.showDefaultTitle();
      }
    });
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
  }
}
