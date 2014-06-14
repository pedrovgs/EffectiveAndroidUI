package com.github.pedrovgs.effectiveandroidui.di;

import com.github.pedrovgs.effectiveandroidui.executor.ExecutorModule;
import dagger.Module;

/**
 * Dagger module created to work as junction of every module with an application scope.
 *
 * @author Pedro Vicente Gómez Sánchez
 */

@Module(
    includes = {
        FrameworkModule.class, ExecutorModule.class
    })
public class RootModule {

}
