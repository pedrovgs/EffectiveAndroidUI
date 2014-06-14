package com.github.pedrovgs.effectiveandroidui.executor;

/**
 * Execute an Interactor. Executor implementation can be based on different frameworks or
 * techniques
 * of asynchronous execution, but every implementation will execute the Interactor out of the UI
 * thread.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public interface Executor {

  void run(final Interactor interactor);
}
