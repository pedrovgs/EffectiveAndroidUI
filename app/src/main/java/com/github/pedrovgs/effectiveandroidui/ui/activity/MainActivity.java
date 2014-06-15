package com.github.pedrovgs.effectiveandroidui.ui.activity;

import android.os.Bundle;
import android.widget.Toast;
import com.github.pedrovgs.effectiveandroidui.R;
import com.github.pedrovgs.effectiveandroidui.domain.GetTvShowById;
import com.github.pedrovgs.effectiveandroidui.domain.GetTvShows;
import com.github.pedrovgs.effectiveandroidui.domain.tvshow.TvShow;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;

public class MainActivity extends BaseActivity {

  @Inject GetTvShows getTvShows;
  @Inject GetTvShowById getTvShowsById;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

   /* getTvShows.execute(new GetTvShows.Callback() {
      @Override public void onTvShowsLoaded(Collection<TvShow> tvShows) {
        Toast.makeText(getBaseContext(), "Conversations loaded " + tvShows.size(),
            Toast.LENGTH_LONG).show();
      }

      @Override public void onConnectionError() {
        Toast.makeText(getBaseContext(), "Fake error", Toast.LENGTH_LONG).show();
      }
    });

*/
    getTvShowsById.execute("The Mentalist", new GetTvShowById.Callback() {
      @Override public void onTvShowLoaded(final TvShow tvShow) {
        Toast.makeText(getBaseContext(), "TvShow loaded " + tvShow.getTitle(), Toast.LENGTH_LONG)
            .show();
      }

      @Override public void onTvShowNotFound() {
        Toast.makeText(getBaseContext(), "TvShow not found", Toast.LENGTH_LONG).show();
      }

      @Override public void onConnectionError() {
        Toast.makeText(getBaseContext(), "CONNECTION ERRROR 000000", Toast.LENGTH_LONG).show();
      }
    });
  }

  @Override
  protected List<Object> getModules() {
    return new LinkedList<Object>();
  }
}
