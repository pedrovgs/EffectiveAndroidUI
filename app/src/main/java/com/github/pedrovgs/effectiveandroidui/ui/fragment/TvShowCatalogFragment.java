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
package com.github.pedrovgs.effectiveandroidui.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ProgressBar;
import butterknife.InjectView;
import com.github.pedrovgs.effectiveandroidui.R;
import com.github.pedrovgs.effectiveandroidui.domain.tvshow.TvShow;
import com.github.pedrovgs.effectiveandroidui.ui.presenter.TvShowCatalogPresenter;
import com.github.pedrovgs.effectiveandroidui.ui.renderer.tvshow.TvShowCollection;
import com.github.pedrovgs.effectiveandroidui.ui.renderer.tvshow.TvShowRendererAdapterFactory;
import com.github.pedrovgs.effectiveandroidui.util.ToastUtils;
import com.pedrogomez.renderers.RendererAdapter;
import java.util.Collection;
import javax.inject.Inject;

/**
 * Fragment created to show a collection of TvShows inside a GridView.
 *
 * This Fragment uses a Model View Presenter implementation to implement all the presentation
 * logic. Review TvShowCatalogPresenter to get more info about the implementation.
 *
 * This fragment is going to notify to the activity every event that has to go out of this
 * fragment. TvShowCatalogFragmentListener is the interface declared by this fragment and
 * implemented by the activity that contains this fragment. This is a common implementation used to
 * notify user actions to the fragment owner. Other approach could be based on a Bus event
 * implementation.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class TvShowCatalogFragment extends BaseFragment implements TvShowCatalogPresenter.View {

  private static final String EXTRA_TV_SHOW_CATALOG = "extra_tv_show_catalog";

  @Inject TvShowCatalogPresenter tvShowCatalogPresenter;
  @Inject TvShowRendererAdapterFactory tvShowRendererAdapterFactory;

  private RendererAdapter<TvShow> adapter;
  private TvShowCollection tvShows = new TvShowCollection();

  @InjectView(R.id.pb_loading) ProgressBar pb_loading;
  @InjectView(R.id.gv_tv_shows) GridView gv_tv_shows;
  @InjectView(R.id.v_empty_case) View v_empty_case;

  @Override public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    initializeGridView();
    tvShowCatalogPresenter.setView(this);
    tvShowCatalogPresenter.initialize();
  }

  @Override public void onAttach(Activity activity) {
    super.onAttach(activity);
  }

  @Override public void onResume() {
    super.onResume();
    tvShowCatalogPresenter.resume();
  }

  @Override public void onPause() {
    super.onPause();
    tvShowCatalogPresenter.pause();
  }

  /**
   * We want to keep the catalog loaded in this fragment even if the user rotates the device. We
   * are
   * using different configurations for landscape and portrait and we have to use this approach
   * instead of onConfigurationChanges.
   */
  @Override public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putSerializable(EXTRA_TV_SHOW_CATALOG, tvShowCatalogPresenter.getCurrentTvShows());
  }

  @Override public void onViewStateRestored(Bundle savedInstanceState) {
    super.onViewStateRestored(savedInstanceState);
    if (savedInstanceState != null) {
      final TvShowCollection tvShowCollection =
          (TvShowCollection) savedInstanceState.getSerializable(EXTRA_TV_SHOW_CATALOG);
      updatePresenterWithSavedTvShow(tvShowCollection);
    }
  }

  @Override public void hideLoading() {
    pb_loading.setVisibility(View.GONE);
  }

  @Override public void showLoading() {
    pb_loading.setVisibility(View.VISIBLE);
  }

  @Override public void renderVideos(final Collection<TvShow> tvShows) {
    this.tvShows.clear();
    this.tvShows.addAll(tvShows);
    refreshAdapter();
  }

  @Override public void updateTitleWithCountOfTvShows(final int counter) {
    String actionBarTitle = getString(R.string.app_name_with_chapter_counter, counter);
    getActivity().setTitle(actionBarTitle);
  }

  @Override public void showConnectionErrorMessage() {
    String connectionError = getString(R.string.connection_error_message);
    ToastUtils.showShortMessage(connectionError, getActivity());
  }

  @Override public void showEmptyCase() {
    v_empty_case.setVisibility(View.VISIBLE);
  }

  @Override public void showDefaultTitle() {
    getActivity().setTitle(R.string.app_name);
  }

  @Override public void showTvShowTitleAsMessage(TvShow tvShow) {
    ToastUtils.showShortMessage(tvShow.getTitle(), getActivity());
  }

  @Override public boolean isReady() {
    return isAdded();
  }

  @Override public boolean isAlreadyLoaded() {
    return adapter.getCount() > 0;
  }

  @Override protected int getFragmentLayout() {
    return R.layout.fragment_tv_shows;
  }

  private void initializeGridView() {
    adapter = tvShowRendererAdapterFactory.getTvShowRendererAdapter(tvShows);
    gv_tv_shows.setAdapter(adapter);
  }

  private void updatePresenterWithSavedTvShow(TvShowCollection tvShowCollection) {
    if (tvShowCollection != null) {
      tvShowCatalogPresenter.loadCatalog(tvShowCollection);
    }
  }

  private void refreshAdapter() {
    adapter.notifyDataSetChanged();
  }
}
