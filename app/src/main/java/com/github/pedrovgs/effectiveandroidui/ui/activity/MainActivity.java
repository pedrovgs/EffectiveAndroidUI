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
package com.github.pedrovgs.effectiveandroidui.ui.activity;

import android.os.Bundle;

import com.github.pedrovgs.effectiveandroidui.R;
import com.github.pedrovgs.effectiveandroidui.ui.fragment.TvShowDraggableFragment;
import com.github.pedrovgs.effectiveandroidui.ui.fragment.TvShowFragment;
import com.github.pedrovgs.effectiveandroidui.ui.presenter.TvShowUIModule;

import java.util.LinkedList;
import java.util.List;

/**
 * Core activity of this application. This activity receives the launch intent and works as core of
 * the sample application.
 */
public class MainActivity extends BaseActivity {

    private TvShowDraggableFragment tvShowDraggableFragment;
    private TvShowFragment tvShowFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeTvShowFragment();
        initializeTvShowDraggableFragment();
    }

    @Override
    protected List<Object> getModules() {
        LinkedList<Object> modules = new LinkedList<>();
        modules.add(new TvShowUIModule());
        return modules;
    }

    private void initializeTvShowFragment() {
        tvShowFragment = (TvShowFragment) getSupportFragmentManager().findFragmentById(R.id.f_tv_show);
    }

    private void initializeTvShowDraggableFragment() {
        tvShowDraggableFragment =
                (TvShowDraggableFragment) getSupportFragmentManager().findFragmentById(
                        R.id.f_tv_show_draggable);
    /*
     * If both fragments are visible we have to disable saved instance state in draggable
     * fragment because there are different fragment configurations in activity_main.xml
     * when the device is in portrait or landscape. Review layout- directory to get more
     * information.
     */
        if (tvShowFragment != null && tvShowDraggableFragment != null) {
            tvShowDraggableFragment.disableSaveInstanceState();
        }
    }
}
