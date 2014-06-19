package com.github.pedrovgs.effectiveandroidui.di;

import java.lang.annotation.Retention;
import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Annotation created to improve Context injection. This annotation is used with @Inject for Context
 * class to return the current Activity context.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
@Qualifier @Retention(RUNTIME)
public @interface ActivityContext {
}

