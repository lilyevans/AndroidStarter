package thoughtworks.com.androidstarter.Song;

import android.widget.ArrayAdapter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;

import thoughtworks.com.androidstarter.BuildConfig;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@Config(constants = BuildConfig.class, sdk = 25)
@RunWith(RobolectricTestRunner.class)
public class SongViewModelTest {
    @Test
    public void shouldBuildArrayAdapterForSong() throws Exception {

        SongService songService = mock(SongService.class);
        SongActivity songActivity = Robolectric.buildActivity(SongActivity.class).get();

        SongViewModel songViewModel = new SongViewModel(songActivity, songService, new ArrayList<String>());
        ArrayAdapter<Song> actualArrayAdapter = songViewModel.buildArrayAdapter();

        verify(songService).getSongs(any(ArrayList.class), any(ArrayAdapter.class));
    }
}