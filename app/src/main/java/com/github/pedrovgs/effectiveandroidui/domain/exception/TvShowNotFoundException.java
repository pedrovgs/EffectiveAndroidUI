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


