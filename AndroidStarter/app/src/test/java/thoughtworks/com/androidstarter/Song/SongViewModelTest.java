package thoughtworks.com.androidstarter.Song;

import android.widget.ArrayAdapter;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;

import thoughtworks.com.androidstarter.BuildConfig;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
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

        assertThat(actualArrayAdapter, Matchers.is(instanceOf(ArrayAdapter.class)));
    }

    @Test
    public void shouldPrepareAndPopulateArrayAdapterUsingSongService() throws Exception {
        SongService songService = mock(SongService.class);
        SongActivity songActivity = Robolectric.buildActivity(SongActivity.class).get();
        ArrayList<String> songIds = mock(ArrayList.class);
        SongViewModel songViewModel = new SongViewModel(songActivity, songService, songIds);

        ArrayAdapter<Song> adapter = mock(ArrayAdapter.class);

        songViewModel.populateAdapter(adapter);

        verify(adapter).setNotifyOnChange(true);
        verify(songService).getSongs(songIds, adapter);
    }
}