package com.github.pedrovgs.effectiveandroidui.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.pedrovgs.effectiveandroidui.R;

/**
 * Fragment created to show a collection of TvShows inside a GridView.
 * This Fragment uses a Model View Presenter implementation to implement all the presentation
 * logic.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class TvShowsFragment extends BaseFragment {

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_tv_shows, container, false);
  }
}
