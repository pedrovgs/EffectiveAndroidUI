package com.github.pedrovgs.effectiveandroidui;

import android.app.Application;
import com.github.pedrovgs.effectiveandroidui.di.RootModule;
import dagger.ObjectGraph;
import java.util.List;

/**
 * Android Application extension created to get the control of the application lifecycle.
 * <p/>
 * This project is using Dependency Injection based on Dagger as dependency injector. The
 * ObjectGraph field used in this class is the dependency container that is going to provide every
 * dependency declared in Dagger modules.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class TvShowsApplication extends Application {

  private ObjectGraph objectGraph;

  @Override
  public void onCreate() {
    super.onCreate();
    initializeDependencyInjector();
  }

  /**
   * Inject every dependency declared in the object with the @Inject annotation if the dependency
   * has been already declared in a module and already initialized by Dagger.
   *
   * @param object to inject.
   */
  public void inject(Object object) {
    objectGraph.inject(object);
  }

  /**
   * Extend the dependency container graph will new dependencies provided by the modules passed as
   * arguments.
   *
   * @param modules used to populate the dependency container.
   */
  public ObjectGraph plus(List<Object> modules) {
    if (modules == null) {
      throw new IllegalArgumentException(
          "You can't plus a null module, review your getModules() implementation");
    }
    return objectGraph.plus(modules.toArray());
  }

  private void initializeDependencyInjector() {
    objectGraph = ObjectGraph.create(new RootModule(this));
    objectGraph.inject(this);
    objectGraph.injectStatics();
  }
}
