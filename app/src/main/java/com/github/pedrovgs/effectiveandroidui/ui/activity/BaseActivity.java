/*
 * Copyright (C) 2014 Pedro Vicente Gómez Sánchez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.pedrovgs.effectiveandroidui.ui.activity;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBarActivity;
import butterknife.ButterKnife;
import com.github.pedrovgs.effectiveandroidui.TvShowsApplication;
import com.github.pedrovgs.effectiveandroidui.di.ActivityModule;
import dagger.ObjectGraph;
import java.util.List;

/**
 * Base activity created to be extended by every activity in this application. This class provides
 * dependency injection configuration, butterknife Android library configuration and some methods
 * common to every activity.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public abstract class BaseActivity extends ActionBarActivity {

  private ObjectGraph activityScopeGraph;

  private GestureDetectorCompat gestureDetectorCompat;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    injectDependencies();
    injectViews();
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
