package com.github.pedrovgs.effectiveandroidui.ui;

import android.app.Activity;
import android.support.v4.app.Fragment;
import com.github.pedrovgs.effectiveandroidui.TvShowsApplication;

/**
 * Base fragment created to be extended by every fragment in this application. This class provides
 * dependency injection configuration, butterknife Android library configuration and some methods
 * common to every fragment.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class BaseFragment extends Fragment {

  @Override public void onAttach(Activity activity) {
    super.onAttach(activity);
    ((TvShowsApplication) activity.getApplication()).inject(this);
  }
}
