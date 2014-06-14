package com.github.pedrovgs.effectiveandroidui.executor;

import android.os.Handler;
import android.os.Looper;
import javax.inject.Inject;

/**
 * MainThread implementation based on a Handler instantiated over the main looper obtained from
 * Looper class.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
class MainThreadImpl implements MainThread {

  private Handler handler;

  @Inject MainThreadImpl() {
    this.handler = new Handler(Looper.getMainLooper());
  }

  public void post(Runnable runnable) {
    handler.post(runnable);
  }
}
