package com.github.pedrovgs.effectiveandroidui.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.InjectView;
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
    if (savedInstanceState == null) {
      getSupportFragmentManager().beginTransaction()
          .add(R.id.container, new PlaceholderFragment())
          .commit();
    }

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

  /**
   * A placeholder fragment containing a simple view.
   */
  public static class PlaceholderFragment extends BaseFragment {

    @InjectView(R.id.tv_hello_world) TextView tv_hello_world;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
      View rootView = inflater.inflate(R.layout.fragment_main, container, false);
      return rootView;
    }

    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);
      tv_hello_world.setText("Good bye!");
    }
  }
}
