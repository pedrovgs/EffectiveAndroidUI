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
package com.github.pedrovgs.effectiveandroidui.ui.presenter;

import com.github.pedrovgs.effectiveandroidui.domain.GetTvShows;
import com.github.pedrovgs.effectiveandroidui.domain.tvshow.TvShow;
import com.github.pedrovgs.effectiveandroidui.ui.activity.Navigator;
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
  private Navigator navigator;

  private View view;
  private TvShowCollection currentTvShowCollection;

  @Inject
  public TvShowCatalogPresenter(GetTvShows getTvShowsInteractor, Navigator navigator) {
    this.getTvShowsInteractor = getTvShowsInteractor;
    this.navigator = navigator;
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

  /**
   * Used to force a TvShowCollection load in the presenter. This method is used by
   * TvShowCatalogFragment when the fragment lifecycle is restored and there are already loaded tv
   * shows.
   */
  public void loadCatalog(final TvShowCollection tvShowCollection) {
    currentTvShowCollection = tvShowCollection;
    showTvShows(tvShowCollection.getAsList());
  }

  public void onTvShowThumbnailClicked(final TvShow tvShow) {
      navigator.openTvShowDetails(tvShow);
  }

  public void onTvShowClicked(final TvShow tvShow) {
    view.showTvShowTitleAsMessage(tvShow);
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
    if (view.isReady()) {
      view.showLoading();
    }
    getTvShowsInteractor.execute(new GetTvShows.Callback() {
      @Override public void onTvShowsLoaded(final Collection<TvShow> tvShows) {
        currentTvShowCollection = new TvShowCollection(tvShows);
        showTvShows(tvShows);
      }

      @Override public void onConnectionError() {
        notifyConnectionError();
      }
    });
  }

  private void notifyConnectionError() {
    if (view.isReady() && !view.isAlreadyLoaded()) {
      view.hideLoading();
      view.showConnectionErrorMessage();
      view.showEmptyCase();
      view.showDefaultTitle();
    }
  }

  private void showTvShows(Collection<TvShow> tvShows) {
    if (view.isReady()) {
      view.renderVideos(tvShows);
      view.hideLoading();
      view.updateTitleWithCountOfTvShows(tvShows.size());
    }
  }

  private void checkViewAlreadySetted() {
    if (view == null) {
      throw new IllegalArgumentException("Remember to set a view for this presenter");
    }
  }

  /**
   * View interface created to abstract the view
   * implementation used in this presenter.
   */
  public interface View {

    void hideLoading();

    void showLoading();

    void renderVideos(final Collection<TvShow> tvShows);

    void updateTitleWithCountOfTvShows(final int counter);

    void showConnectionErrorMessage();

    void showEmptyCase();

    void showDefaultTitle();

    void showTvShowTitleAsMessage(TvShow tvShow);

    boolean isReady();

    boolean isAlreadyLoaded();
  }
}
