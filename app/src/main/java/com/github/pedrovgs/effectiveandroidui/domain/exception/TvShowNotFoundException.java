package com.github.pedrovgs.effectiveandroidui.domain.exception;

/**
 * Exception throw by the application when a TvShow search can't return a valid result.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class TvShowNotFoundException extends Exception {

  public TvShowNotFoundException() {
    super();
  }

  public TvShowNotFoundException(final String message) {
    super(message);
  }

  public TvShowNotFoundException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public TvShowNotFoundException(final Throwable cause) {
    super(cause);
  }
}


