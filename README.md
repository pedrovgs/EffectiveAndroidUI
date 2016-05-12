Effective Android UI [![Build Status](https://travis-ci.org/pedrovgs/EffectiveAndroidUI.svg?branch=master)](https://travis-ci.org/pedrovgs/EffectiveAndroidUI) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-EffectiveAndroidUI-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/1347)
====================

Sample project created to reinforce some of the main concepts described in the tech talk "Effective Android UI".

In this repository you are going to find some interesting samples like:

* **MVP** and **MVVM (without data binding engine)** samples.
* How to use **fragments**.
* How to use **Dagger to implement dependency injection**.
* Use **resource qualifiers** to change the layout used in **different screen sizes**.
* Use **resource qualifiers** to change the layout used in **different screen densities**.
* Use **resource qualifiers** to change the layout in **different Android version**.
* How to use **styles and themes**.
* How to **communicate fragments** in the same activity.
* **Butterknife** library usage to **avoid UI duplicated code**.
* Uniform **naming** for Android resources.
* How to use **Navigator** or **ActionCommands** to **implement the navigation** inside the application.
* Use resource custom qualifiers to **split resource files by domain**.
* Different **layout usage**: RelativeLayout, LinearLayout, FrameLayout.
* Usage of **merge, include and view stub**.
* Correct **ListView** implementation with **view recycle** using **Renderers**.
* **Interactor implementation** described in the talk "Software Design Patterns on Android".
* Usage of **Dagger to implement two different scopes: Application scope and Activity scope**.

Implementation description
--------------------------

[EffectiveAndroid UI Video - Spanish][4]

[EffectiveAndroid UI Slides - English][5]

Screenshots
------------

![Demo Screenshot 1][1]
![Demo Screenshot 2][2]
![Demo Screenshot 3][3]

Libraries used on the sample project
------------------------------------

* [Renderers][6]
* [Dagger][7]
* [Butterknife][8]
* [Picasso][9]
* [DraggablePanel][10]


Developed By
------------

* Pedro Vicente Gómez Sánchez - <pedrovicente.gomez@gmail.com>

<a href="https://twitter.com/pedro_g_s">
  <img alt="Follow me on Twitter" src="https://image.freepik.com/iconos-gratis/twitter-logo_318-40209.jpg" height="60" width="60"/>
</a>
<a href="https://es.linkedin.com/in/pedrovgs">
  <img alt="Add me to Linkedin" src="https://image.freepik.com/iconos-gratis/boton-del-logotipo-linkedin_318-84979.png" height="60" width="60"/>
</a>


License
-------

    Copyright 2014 Pedro Vicente Gómez Sánchez

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[1]: ./art/screenshot1.png
[2]: ./art/screenshot2.png
[3]: ./art/screenshot3.png
[4]: https://www.youtube.com/watch?v=N6yqe88ysNw
[5]: http://www.slideshare.net/PedroVicenteGmezSnch/effective-android-ui-english
[6]: https://github.com/pedrovgs/Renderers
[7]: https://github.com/square/dagger
[8]: https://github.com/JakeWharton/butterknife
[9]: https://github.com/square/picasso
[10]: https://github.com/pedrovgs/DraggablePanel
