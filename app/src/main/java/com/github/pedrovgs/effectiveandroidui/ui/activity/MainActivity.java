package com.github.pedrovgs.effectiveandroidui.ui.activity;

import android.os.Bundle;
import com.github.pedrovgs.effectiveandroidui.R;
import com.github.pedrovgs.effectiveandroidui.domain.GetTvShowById;
import com.github.pedrovgs.effectiveandroidui.domain.GetTvShows;
import com.github.pedrovgs.effectiveandroidui.domain.tvshow.TvShow;
import com.github.pedrovgs.effectiveandroidui.ui.fragment.TvShowCatalogFragment;
import com.github.pedrovgs.effectiveandroidui.ui.presenter.TvShowCatalogModule;
import com.github.pedrovgs.effectiveandroidui.util.ToastUtils;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;

public class MainActivity extends BaseActivity implements TvShowCatalogFragment.Listener {

  @Inject GetTvShows getTvShows;
  @Inject GetTvShowById getTvShowsById;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  @Override
  protected List<Object> getModules() {
    LinkedList<Object> modules = new LinkedList<Object>();
    modules.add(new TvShowCatalogModule());
    return modules;
  }

  @Override public void onTvShowClicked(final TvShow tvShow) {
    ToastUtils.showError(tvShow.getEpisodes().getChapters().size() + "episodes", this);
  }
}
