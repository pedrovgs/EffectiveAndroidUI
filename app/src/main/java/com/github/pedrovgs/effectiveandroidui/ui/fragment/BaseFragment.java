package com.github.pedrovgs.effectiveandroidui.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import butterknife.ButterKnife;
import com.github.pedrovgs.effectiveandroidui.ui.activity.BaseActivity;

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
    injectDependencies();
  }

  @Override public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    injectViews(view);
  }

  /**
   * Replace every field annotated with @Inject annotation with the provided dependency specified
   * inside a Dagger module value.
   */
  private void injectDependencies() {
    ((BaseActivity) getActivity()).inject(this);
  }

  /**
   * Replace every field annotated with ButterKnife annotations like @InjectView with the proper
   * value.
   *
   * @param view to extract each widget injected in the fragment.
   */
  private void injectViews(final View view) {
    ButterKnife.inject(this, view);
  }
}
