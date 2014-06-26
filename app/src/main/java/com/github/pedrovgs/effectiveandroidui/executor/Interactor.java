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
package com.github.pedrovgs.effectiveandroidui.executor;

/**
 * Common interface to every Interactor declared in the application. This interface represents a
 * execution unit for different use cases.
 *
 * By convention every interactor implementation will return the result using a Callback. That
 * callback should be executed over the UI thread.
 *
 * This is a simple Interactor implementation. Other approach to do this could be use a class
 * instead of an interface and create a base Interactor class that for every execution will use a
 * Request object and a callback implementation.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public interface Interactor {
  void run();
}
