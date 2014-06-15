package com.github.pedrovgs.effectiveandroidui.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Some utility methods related with the Toast class.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class ToastUtils {

  public static void showError(final String message, final Context context) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show();
  }
}
