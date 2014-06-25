package com.github.pedrovgs.effectiveandroidui.ui.theme;

import com.github.pedrovgs.effectiveandroidui.R;

/**
 * Class created to controll the application theme.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class ThemeController {

  private int currentTheme = R.style.AppTheme;

  public ThemeController() {
    //Empty
  }

  public int getCurrentTheme() {
    return currentTheme;
  }

  public void enableLightTheme() {
    this.currentTheme = R.style.AppTheme;
  }

  public void enableDarkTheme() {
    this.currentTheme = R.style.AppTheme_Dark;
  }
}
