package thoughtworks.com.androidstarter.Song;

import android.widget.ArrayAdapter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;

import thoughtworks.com.androidstarter.BuildConfig;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Config(constants = BuildConfig.class, sdk = 25)
@RunWith(RobolectricTestRunner.class)
public class SongViewModelTest {
    @Test
    public void shouldBuildArrayAdapterForSong() throws Exception {
        Song song = mock(Song.class);
        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(song);

        SongService songService = mock(SongService.class);
        when(songService.getSongs(any(ArrayList.class))).thenReturn(songs);

        SongActivity songActivity = Robolectric.buildActivity(SongActivity.class).get();

        SongViewModel songViewModel = new SongViewModel(songActivity, songService, new ArrayList<String>());
        ArrayAdapter<Song> actualArrayAdapter = songViewModel.buildArrayAdapter();

        assertThat(actualArrayAdapter.getItem(0), is(equalTo(song)));
    }
}