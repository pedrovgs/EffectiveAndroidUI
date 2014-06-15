package com.github.pedrovgs.effectiveandroidui.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ProgressBar;
import butterknife.InjectView;
import com.github.pedrovgs.effectiveandroidui.R;
import com.github.pedrovgs.effectiveandroidui.domain.tvshow.TvShow;
import com.github.pedrovgs.effectiveandroidui.ui.presenter.TvShowCatalogPresenter;
import com.github.pedrovgs.effectiveandroidui.util.ToastUtils;
import java.util.Collection;
import javax.inject.Inject;

/**
 * Fragment created to show a collection of TvShows inside a GridView.
 * This Fragment uses a Model View Presenter implementation to implement all the presentation
 * logic.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class TvShowCatalogFragment extends BaseFragment implements TvShowCatalogPresenter.View {

  @Inject TvShowCatalogPresenter presenter;

  @InjectView(R.id.pb_loading) ProgressBar pb_loading;
  @InjectView(R.id.gv_tv_shows) GridView gv_tv_shows;
  @InjectView(R.id.v_empty_case) View v_empty_case;

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_tv_shows, container, false);
  }

  @Override public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    presenter.setView(this);
    presenter.initialize();
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
    //Render videos inside adapter here
  }

  @Override public void updateTitleWithCountOfVideow(final int counter) {
    String actionBarTitle = getString(R.string.app_name) + " - " + counter;
    getActivity().setTitle(actionBarTitle);
  }

  @Override public void showConnectionErrorMessage() {
    String connectionError = getString(R.string.connection_error_message);
    ToastUtils.showError(connectionError, getActivity());
  }

  @Override public void showEmptyCase() {
    v_empty_case.setVisibility(View.VISIBLE);
  }

  @Override public void showDefaultTitle() {
    getActivity().setTitle(R.string.app_name);
  }
}
