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
package com.github.pedrovgs.effectiveandroidui.di;

import android.content.Context;
import android.view.LayoutInflater;
import com.github.pedrovgs.effectiveandroidui.TvShowsApplication;
import com.github.pedrovgs.effectiveandroidui.domain.TvShowsModule;
import com.github.pedrovgs.effectiveandroidui.executor.ExecutorModule;
import dagger.Module;
import dagger.Provides;

/**
 * Dagger module created to work as junction of every module with an application scope.
 *
 * This module provides every application scope dependencies related with the AndroidSDK.
 *
 * @author Pedro Vicente Gómez Sánchez
 */

@Module(
    includes = {
        ExecutorModule.class, TvShowsModule.class,
    },
    injects = {
        TvShowsApplication.class
    }, library = true)
public final class RootModule {

  private final Context context;

  public RootModule(Context context) {
    this.context = context;
  }

  @Provides Context provideApplicationContext() {
    return context;
  }

  @Provides LayoutInflater provideLayoutInflater() {
    return LayoutInflater.from(context);
  }
}
