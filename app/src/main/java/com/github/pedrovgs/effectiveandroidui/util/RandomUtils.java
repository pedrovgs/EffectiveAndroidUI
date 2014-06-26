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

import java.util.Random;

/**
 * Some utility methods related with the Random class.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class RandomUtils {

  private static final Random RANDOM = new Random();

  private RandomUtils() {
    //Empty
  }

  /**
   * Return true of false using a random value generated and the percentage passed as parameter.
   *
   * @param percentage to evaluate.
   * @return true fifty percent of the times it's executed if the percentage parameter is 50.
   */
  public static boolean percent(final int percentage) {
    return (RANDOM.nextInt(100) < percentage);
  }

  /**
   * Returns a random integer between 0 and the maxValue argument, included maxValue.
   */
  public static int getRandomValueBelow(final int maxValue) {
    return RANDOM.nextInt(maxValue + 1);
  }
}
