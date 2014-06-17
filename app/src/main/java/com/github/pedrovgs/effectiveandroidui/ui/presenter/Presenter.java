package com.github.pedrovgs.effectiveandroidui.ui.presenter;

/**
 * Abstract presenter to work as base for every presenter created in the application. This
 * presenter
 * declares some methods to attach the fragment/activity lifecycle.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public abstract class Presenter {

  /**
   * Called when the presenter is initialized, this method represents the start of the presenter
   * lifecycle.
   */
  public abstract void initialize();

  /**
   * Called when the presenter is resumed. After the initialization and when the presenter comes
   * from a pause state.
   */
  public abstract void resume();

  /**
   * Called when the presenter is paused.
   */
  public abstract void pause();
}
