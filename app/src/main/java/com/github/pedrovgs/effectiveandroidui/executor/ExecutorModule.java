package com.github.pedrovgs.effectiveandroidui.executor;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Dagger module created to provide every dependency related with our execution service. Main
 * dependencies provided by this module are: Executor and MainThread.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
@Module(library = true)
public class ExecutorModule {

  @Provides @Singleton Executor provideExecutor(ThreadExecutor threadExecutor) {
    return threadExecutor;
  }

  @Provides @Singleton MainThread provideMainThread(MainThreadImpl mainThread) {
    return mainThread;
  }
}
