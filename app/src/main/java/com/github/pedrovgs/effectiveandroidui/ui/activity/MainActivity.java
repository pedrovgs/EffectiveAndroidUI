package com.github.pedrovgs.effectiveandroidui.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.github.pedrovgs.effectiveandroidui.R;
import com.github.pedrovgs.effectiveandroidui.domain.GetTvShowById;
import com.github.pedrovgs.effectiveandroidui.domain.GetTvShows;
import com.github.pedrovgs.effectiveandroidui.domain.tvshow.TvShow;
import com.github.pedrovgs.effectiveandroidui.ui.fragment.TvShowCatalogFragment;
import com.github.pedrovgs.effectiveandroidui.ui.fragment.TvShowDraggableFragment;
import com.github.pedrovgs.effectiveandroidui.ui.fragment.TvShowFragment;
import com.github.pedrovgs.effectiveandroidui.ui.presenter.TvShowUIModule;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;

public class MainActivity extends BaseActivity implements TvShowCatalogFragment.Listener {

  @Inject GetTvShows getTvShows;
  @Inject GetTvShowById getTvShowsById;

  private TvShowDraggableFragment tvShowDraggableFragment;
  private TvShowFragment tvShowFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    tvShowDraggableFragment =
        (TvShowDraggableFragment) getSupportFragmentManager().findFragmentById(
            R.id.f_tv_show_draggable);
    tvShowFragment = (TvShowFragment) getSupportFragmentManager().findFragmentById(R.id.f_tv_show);
  }

  @Override
  protected List<Object> getModules() {
    LinkedList<Object> modules = new LinkedList<Object>();
    modules.add(new TvShowUIModule());
    return modules;
  }

  @Override public void onTvShowClicked(final TvShow tvShow) {
    showTvShowOnTvShowDraggableFragment(tvShow);
    showTvShowOnTvShowFragment(tvShow);
  }

  private void showTvShowOnTvShowDraggableFragment(TvShow tvShow) {
    if (isFragmentAvailable(tvShowDraggableFragment)) {
      //tvShowDraggableFragment.showTvShow(tvShow.getTitle());
    }
  }

  private void showTvShowOnTvShowFragment(TvShow tvShow) {
    if (isFragmentAvailable(tvShowFragment)) {
      tvShowFragment.showTvShow(tvShow.getTitle());
    }
  }

  private boolean isFragmentAvailable(Fragment fragment) {
    return fragment != null;
  }
}
