package com.github.pedrovgs.effectiveandroidui.ui.renderer.chapterviewmodel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.github.pedrovgs.effectiveandroidui.R;
import com.github.pedrovgs.effectiveandroidui.ui.viewmodel.ChapterViewModel;
import com.pedrogomez.renderers.Renderer;
import javax.inject.Inject;

/**
 * Renderer implementation for ChapterViewModel objects.
 *
 * If you want to lear more about how to use Renderers take a look to this project:
 * https://github.com/pedrovgs/Renderers
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class ChapterViewModelRenderer extends Renderer<ChapterViewModel> {

  @InjectView(R.id.tv_chapter_number) TextView tv_chapter_number;
  @InjectView(R.id.tv_chapter_title) TextView tv_chapter_title;
  @InjectView(R.id.tv_chapter_publish_date) TextView tv_chapter_publish_date;

  @Inject
  public ChapterViewModelRenderer() {
  }

  private int position;

  public void setPosition(int position) {
    this.position = position;
  }

  @Override
  protected void setUpView(View view) {
    ButterKnife.inject(this, view);
  }

  @Override
  protected void hookListeners(View view) {
    //Empty because we are using ButterKnife to inject views.
  }

  @Override
  protected View inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
    return layoutInflater.inflate(R.layout.row_chapter, viewGroup, false);
  }

  @Override
  public void render() {
    ChapterViewModel chapter = getContent();
    renderChapterNumber();
    renderChapterTitle(chapter);
    renderChapterPublishDate(chapter);
  }

  private void renderChapterNumber() {
    tv_chapter_number.setText(String.format("%02d", position + 1));
  }

  private void renderChapterTitle(ChapterViewModel episode) {
    tv_chapter_title.setText(episode.getTitle());
  }

  private void renderChapterPublishDate(ChapterViewModel episode) {
    tv_chapter_publish_date.setText(episode.getPublishDate());
  }
}
