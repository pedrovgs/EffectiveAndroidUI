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
 * fragment.
 * TvShowCatalogFragmentListener is the interface declared by this fragment and implemented by the
 * activity that contains this fragment.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class TvShowCatalogFragment extends BaseFragment implements TvShowCatalogPresenter.View {

  @Inject TvShowCatalogPresenter presenter;
  @Inject TvShowRendererAdapterFactory tvShowRendererAdapterFactory;

  private RendererAdapter<TvShow> adapter;
  private TvShowCollection tvShows = new TvShowCollection();

  private Listener listener;

  @InjectView(R.id.pb_loading) ProgressBar pb_loading;
  @InjectView(R.id.gv_tv_shows) GridView gv_tv_shows;
  @InjectView(R.id.v_empty_case) View v_empty_case;

  @Override public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    initializeGridView();
    presenter.setView(this);
    presenter.initialize();
  }

  @Override public void onAttach(Activity activity) {
    super.onAttach(activity);
    if (activity instanceof Listener) {
      this.listener = (Listener) activity;
    }
  }

  @Override public void onResume() {
    super.onResume();
    presenter.resume();
  }

  @Override public void onPause() {
    super.onPause();
    presenter.pause();
  }

  @Override public void hideLoading() {
    pb_loading.setVisibility(View.GONE);
  }

  @Override public void renderVideos(final Collection<TvShow> tvShows) {
    this.tvShows.clear();
    this.tvShows.addAll(tvShows);
    refreshAdapter();
  }

  @Override public void updateTitleWithCountOfVideow(final int counter) {
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

  @Override public void showTvShowInfo(TvShow tvShow) {
    ToastUtils.showError(tvShow.getTitle(), getActivity());
  }

  @Override public void showTvShow(final TvShow tvShow) {
    if (listener != null) {
      listener.onTvShowClicked(tvShow);
    }
  }

  @Override protected int getFragmentLayout() {
    return R.layout.fragment_tv_shows;
  }

  private void initializeGridView() {
    adapter = tvShowRendererAdapterFactory.getTvShowRendererAdapter(tvShows);
    gv_tv_shows.setAdapter(adapter);
  }

  private void refreshAdapter() {
    adapter.notifyDataSetChanged();
  }

  public interface Listener {

    void onTvShowClicked(final TvShow tvShow);
  }
}
