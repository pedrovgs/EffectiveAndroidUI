package com.github.pedrovgs.effectiveandroidui.util;

import android.os.Handler;

/**
 * Utility class created to send messages to the future using an Android Handler.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class TimeMachine {

  private static Handler handler = new Handler();

  /**
   * Execute a Runnable implementation some milliseconds in the future.
   *
   * @param runnable to execute.
   * @param delay in miliseconds.
   */
  public static void sendMessageToTheFuture(final Runnable runnable, final int delay) {
    handler.postDelayed(runnable, delay);
  }

  /**
   * Cancel a message already sent to the future.
   */
  public static void cancelMessage(Runnable runnable) {
    handler.removeCallbacks(runnable);
  }
}
