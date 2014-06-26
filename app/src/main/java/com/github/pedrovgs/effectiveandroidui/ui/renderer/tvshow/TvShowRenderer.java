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
package com.github.pedrovgs.effectiveandroidui.ui.renderer.tvshow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.github.pedrovgs.effectiveandroidui.R;
import com.github.pedrovgs.effectiveandroidui.domain.tvshow.TvShow;
import com.github.pedrovgs.effectiveandroidui.ui.presenter.TvShowCatalogPresenter;
import com.pedrogomez.renderers.Renderer;
import com.squareup.picasso.Picasso;
import javax.inject.Inject;

/**
 * Renderer implementation for TvShow objects.
 *
 * If you want to lear more about how to use Renderers take a look to this project:
 * https://github.com/pedrovgs/Renderers
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class TvShowRenderer extends Renderer<TvShow> {

  private final Context context;
  private final TvShowCatalogPresenter tvShowCatalogPresenter;

  @InjectView(R.id.iv_thumbnail) ImageView thumbnailImageView;
  @InjectView(R.id.tv_title) TextView titleTextView;
  @InjectView(R.id.tv_seasons_counter) TextView seasonsCounterTextView;

  @Inject
  public TvShowRenderer(Context context, TvShowCatalogPresenter tvShowCatalogPresenter) {
    this.context = context;
    this.tvShowCatalogPresenter = tvShowCatalogPresenter;
  }

  @Override protected void setUpView(View rootView) {
    ButterKnife.inject(this, rootView);
  }

  @Override protected void hookListeners(View rootView) {
    //Empty because we are using ButterKnife library
  }

  @Override protected View inflate(LayoutInflater inflater, ViewGroup parent) {
    return inflater.inflate(R.layout.row_tv_show, parent, false);
  }

  @Override public void render() {
    TvShow tvShow = getContent();
    renderThumbnail(tvShow);
    renderTitle(tvShow);
    renderSeasonCounter(tvShow);
  }

  @OnClick(R.id.iv_thumbnail) void onThumbnailClicked() {
    tvShowCatalogPresenter.onTvShowThumbnailClicked(getContent());
  }

  @OnClick(R.id.v_row_container) void onBackgroundClicked() {
    tvShowCatalogPresenter.onTvShowClicked(getContent());
  }

  private TvShow renderThumbnail(TvShow tvShow) {
    Picasso.with(context).load(tvShow.getPoster()).into(thumbnailImageView);
    return tvShow;
  }

  private void renderTitle(TvShow tvShow) {
    titleTextView.setText(tvShow.getTitle().toUpperCase());
  }

  private void renderSeasonCounter(TvShow tvShow) {
    String seassons = context.getString(R.string.seasons_counter, tvShow.getNumberOfSeasons());
    seasonsCounterTextView.setText(seassons);
  }
}
