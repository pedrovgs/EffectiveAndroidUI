package com.github.pedrovgs.effectiveandroidui.ui.presenter;

import com.github.pedrovgs.effectiveandroidui.domain.GetTvShows;
import com.github.pedrovgs.effectiveandroidui.domain.tvshow.TvShow;
import com.github.pedrovgs.effectiveandroidui.ui.fragment.TvShowsFragment;
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
public class TvShowsPresenter {

  private GetTvShows getTvShowsInteractor;

  private View view;

  @Inject
  public TvShowsPresenter(GetTvShows getTvShowsInteractor) {
    this.getTvShowsInteractor = getTvShowsInteractor;
  }

  public void setView(TvShowsFragment view) {
    this.view = view;
  }

  /**
   * Called when the presenter is initialized, this method represents the start of the presenter
   * lifecycle.
   */
  public void initialize() {
    loadVideos();
  }

  /**
   * Called when the presenter is resumed. After the initialization and when the presenter comes
   * from a pause state.
   */
  public void resume() {
    //Empty
  }

  /**
   * Called when the presenter is paused.
   */
  public void pause() {
    //Empty
  }

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
