package com.github.pedrovgs.effectiveandroidui.ui.activity;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBarActivity;
import butterknife.ButterKnife;
import com.github.pedrovgs.effectiveandroidui.TvShowsApplication;
import com.github.pedrovgs.effectiveandroidui.di.ActivityModule;
import com.github.pedrovgs.effectiveandroidui.ui.theme.ThemeController;
import dagger.ObjectGraph;
import java.util.List;
import javax.inject.Inject;

/**
 * Base activity created to be extended by every activity in this application. This class provides
 * dependency injection configuration, butterknife Android library configuration and some methods
 * common to every activity.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public abstract class BaseActivity extends ActionBarActivity {

  private ObjectGraph activityScopeGraph;

  @Inject ThemeController themeController;

  private GestureDetectorCompat gestureDetectorCompat;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    injectDependencies();
    injectViews();
    initializeTheme();
  }

  /**
   * Method used to resolve dependencies provided by Dagger modules.
   *
   * @param object to inject.
   */
  public void inject(Object object) {
    activityScopeGraph.inject(object);
  }

  /**
   * Get a list of Dagger modules with Activity scope needed to this Activity.
   *
   * @return modules with new dependencies to provide.
   */
  protected abstract List<Object> getModules();

  /**
   * Set the current application theme to the activity after the setContentView() call.
   */
  private void initializeTheme() {
    setTheme(themeController.getCurrentTheme());
  }

  /**
   * Modify Dagger ObjectGraph to add new dependencies using a plus operation and inject the
   * declared one in the activity. This new dependencies will be removed from the gobal graph once
   * the activity lifecycle finish.
   */
  private void injectDependencies() {
    TvShowsApplication tvShowsApplication = (TvShowsApplication) getApplication();
    List<Object> activityScopeModules = getModules();
    activityScopeModules.add(new ActivityModule(this));
    activityScopeGraph = tvShowsApplication.plus(activityScopeModules);
    inject(this);
  }

  /**
   * Replace every field annotated with ButterKnife annotations like @InjectView with the proper
   * value.
   */
  private void injectViews() {
    ButterKnife.inject(this);
  }
}
