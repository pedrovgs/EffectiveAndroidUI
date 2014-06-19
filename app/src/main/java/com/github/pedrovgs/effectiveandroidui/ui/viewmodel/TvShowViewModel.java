package com.github.pedrovgs.effectiveandroidui.ui.viewmodel;

import com.github.pedrovgs.effectiveandroidui.domain.GetTvShowById;
import com.github.pedrovgs.effectiveandroidui.domain.tvshow.Chapter;
import com.github.pedrovgs.effectiveandroidui.domain.tvshow.ChapterCollection;
import com.github.pedrovgs.effectiveandroidui.domain.tvshow.TvShow;
import com.github.pedrovgs.effectiveandroidui.ui.fragment.TvShowFragment;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;

/**
 * ViewModel crated to represent a TvShow from the presentation point of view.
 *
 * This class could be a interface implementation if the TvShowViewModel has more than one
 * implementation.
 *
 * @author Pedro Vicente Gómez Sánchez
 */
public class TvShowViewModel {

  private final GetTvShowById getTvShowById;

  private TvShowFragment listener;

  @Inject
  public TvShowViewModel(GetTvShowById getTvShowById) {
    this.getTvShowById = getTvShowById;
  }

  public void loadTvShow(final String tvShowId) {
    listener.onEmptyCaseVisibilityChanged(false);
    listener.onLoadVisibilityChanged(false);
    getTvShowById.execute(tvShowId, new GetTvShowById.Callback() {
      @Override public void onTvShowLoaded(TvShow tvShow) {
        listener.onFanArtLoaded(tvShow.getFanArt());
        listener.onTvShowTitleLoaded(tvShow.getTitle());
        listener.onChaptersLoaded(getChaptersViewModel(tvShow.getChapters()));
        listener.onVisibilityChanged(true);
        listener.onLoadVisibilityChanged(false);
        listener.onEmptyCaseVisibilityChanged(false);
      }

      @Override public void onTvShowNotFound() {
        listener.onLoadVisibilityChanged(false);
        listener.onEmptyCaseVisibilityChanged(true);
        listener.onTvShowMessageNotFound();
      }

      @Override public void onConnectionError() {
        listener.onLoadVisibilityChanged(false);
        listener.onEmptyCaseVisibilityChanged(true);
        listener.onConnectionErrorMessageNotFound();
      }
    });
  }

  private List<ChapterViewModel> getChaptersViewModel(ChapterCollection chapterCollection) {
    List<ChapterViewModel> chapterViewModels = new LinkedList<ChapterViewModel>();
    for (Chapter chapter : chapterCollection) {
      chapterViewModels.add(new ChapterViewModel(chapter));
    }
    return chapterViewModels;
  }

  public void setListener(TvShowFragment listener) {
    this.listener = listener;
  }

  public TvShowFragment getListener() {
    return listener;
  }

  public interface Listener {

    void onFanArtLoaded(final String fanArt);

    void onTvShowTitleLoaded(final String tvShowTitle);

    void onChaptersLoaded(final List<ChapterViewModel> chapters);

    void onVisibilityChanged(final boolean visible);

    void onLoadVisibilityChanged(final boolean visible);

    void onEmptyCaseVisibilityChanged(final boolean visible);

    void onTvShowMessageNotFound();

    void onConnectionErrorMessageNotFound();
  }
}
