package com.github.pedrovgs.effectiveandroidui.di;

import com.github.pedrovgs.effectiveandroidui.TvShowsApplication;
import com.github.pedrovgs.effectiveandroidui.domain.TvShowsModule;
import com.github.pedrovgs.effectiveandroidui.executor.ExecutorModule;
import com.github.pedrovgs.effectiveandroidui.ui.activity.MainActivity;
import dagger.Module;

/**
 * Dagger module created to work as junction of every module with an application scope.
 *
 * @author Pedro Vicente Gómez Sánchez
 */

@Module(
    includes = {
        FrameworkModule.class, ExecutorModule.class, TvShowsModule.class
    }, injects = {
    TvShowsApplication.class, MainActivity.class
}
)
public class RootModule {

}
