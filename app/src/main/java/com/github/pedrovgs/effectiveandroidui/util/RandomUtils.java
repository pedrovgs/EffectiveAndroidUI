package com.github.pedrovgs.effectiveandroidui.util;

import java.util.Random;

/**
 * Some utility methods related with the Random class.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class RandomUtils {

  private static final Random random = new Random();

  /**
   * Return true of false using a random value generated and the percentage passed as parameter.
   *
   * @param percentage to evaluate.
   * @return true fifty percent of the times it's executed if the percentage parameter is 50.
   */
  public static boolean percent(final int percentage) {
    return (random.nextInt(100) < percentage);
  }

  /**
   * Returns a random integer between 0 and the maxValue argument, included maxValue.
   */
  public static int getRandomValueBelow(final int maxValue) {
    return random.nextInt(maxValue + 1);
  }
}
