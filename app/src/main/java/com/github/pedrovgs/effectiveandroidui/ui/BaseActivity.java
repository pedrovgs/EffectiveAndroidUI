package com.github.pedrovgs.effectiveandroidui.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import com.github.pedrovgs.effectiveandroidui.TvShowsApplication;
import java.util.List;

/**
 * Base activity created to be extended by every activity in this application. This class provides
 * dependency injection configuration, butterknife Android library configuration and some methods
 * common to every activity.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public abstract class BaseActivity extends ActionBarActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    injectDependencies();
  }

  /**
   * Modify Dagger ObjectGraph to add new dependencies using a plus operation and inject the
   * declared one in the activity. This new dependencies will be removed from the gobal graph once
   * the activity lifecycle finish.
   */
  private void injectDependencies() {
    TvShowsApplication tvShowsApplication = (TvShowsApplication) getApplication();
    tvShowsApplication.plus(getModules());
    tvShowsApplication.inject(this);
  }

  /**
   * Get a list of Dagger modules with Activity scope needed to this Activity.
   *
   * @return modules with new dependencies to provide.
   */
  protected abstract List<Object> getModules();
}
