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
package com.github.pedrovgs.effectiveandroidui.util;

import android.os.Handler;

/**
 * Utility class created to send messages to the future using an Android Handler.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class TimeMachine {

  private static Handler handler = new Handler();

  private TimeMachine() {
    //Empty
  }

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
