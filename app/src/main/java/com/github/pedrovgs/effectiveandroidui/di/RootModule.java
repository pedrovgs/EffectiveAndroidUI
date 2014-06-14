package com.github.pedrovgs.effectiveandroidui.di;

import dagger.Module;

/**
 * Dagger module created to work as junction of every module with an application scope.
 *
 * @author Pedro Vicente Gómez Sánchez
 */

@Module(
    includes = {
        FrameworkModule.class, ExecutionModule.class
    })
public class RootModule {

}
