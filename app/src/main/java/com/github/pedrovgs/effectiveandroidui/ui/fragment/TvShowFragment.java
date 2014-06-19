package com.github.pedrovgs.effectiveandroidui.ui.fragment;

import com.github.pedrovgs.effectiveandroidui.R;

/**
 * Fragment created to show a TvShows. This fragment is going to be used in the tablet version.
 *
 * This Fragment uses a Model View View Model implementation to implement all the presentation
 * logic. Review TvShowViewModel to get more info about the implementation.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class TvShowFragment extends BaseFragment {

  @Override protected int getFragmentLayout() {
    return R.layout.fragment_tv_show;
  }
}
