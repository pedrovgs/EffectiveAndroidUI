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
 * This presenter is not attached to the fragment lifecycle because we don't have to show any
 * TvShow
 * until the TvShow be selected by the user or updated by the fragment lifecycle while the restore
 * instance state process.
 *
 * @author Pedro Vicente Gómez Sánchez
 */

@Singleton
public class TvShowPresenter extends Presenter {

  private final GetTvShowById getTvShowById;
  private TvShow currentTvShow;

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

  public TvShow getCurrentTvShow() {
    return currentTvShow;
  }

  public void tvShowClosed() {
    currentTvShow = null;
  }

  public void loadTvShow(final TvShow tvShow) {
    showTvShow(tvShow);
  }

  public void loadTvShow(final String tvShowId) {
    view.showLoading();
    getTvShowById.execute(tvShowId, new GetTvShowById.Callback() {
      @Override public void onTvShowLoaded(TvShow tvShow) {
        showTvShow(tvShow);
      }

      @Override public void onTvShowNotFound() {
        showTvShowNotFound();
      }

      @Override public void onConnectionError() {
        showConnectionError();
      }
    });
  }

  private void showConnectionError() {
    if (view.isReady() && !view.isAlreadyLoaded()) {
      currentTvShow = null;
      view.hideLoading();
      view.showConnectionErrorMessage();
    }
  }

  private void showTvShowNotFound() {
    if (view.isReady()) {
      currentTvShow = null;
      view.hideLoading();
      view.showTvShowNotFoundMessage();
    }
  }

  private void showTvShow(TvShow tvShow) {
    if (view.isReady()) {
      currentTvShow = tvShow;
      view.showFanArt(tvShow.getFanArt());
      view.showTvShowTitle(tvShow.getTitle().toUpperCase());
      view.showChapters(tvShow.getChapters());
      view.hideLoading();
      view.showTvShow();
    }
  }

  /**
   * View interface created to abstract the view implementation used in this presenter.
   */
  public interface View {

    void showLoading();

    void showFanArt(final String tvShowFanArtUrl);

    void showChapters(final ChapterCollection episodes);

    void hideLoading();

    void showTvShowNotFoundMessage();

    void showConnectionErrorMessage();

    void showTvShow();

    void showTvShowTitle(String tvShowTitle);

    boolean isReady();

    boolean isAlreadyLoaded();
  }
}
