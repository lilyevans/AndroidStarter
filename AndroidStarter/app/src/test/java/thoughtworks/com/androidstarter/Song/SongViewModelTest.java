package thoughtworks.com.androidstarter.Song;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SongViewModelTest {
    @Test
    public void shouldBuildArrayAdapterForSong() throws Exception {
        SongService songService = mock(SongService.class);
        SongViewModel songViewModel = new SongViewModel(songService);

        Context mockContext = mock(Context.class);
        when(mockContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).thenReturn(mock(LayoutInflater.class));

        ArrayAdapter<Song> actualArrayAdapter = songViewModel.buildArrayAdapter(mockContext);

        assertThat(actualArrayAdapter, Matchers.is(instanceOf(ArrayAdapter.class)));
    }

    @Test
    public void shouldPrepareAndPopulateArrayAdapterUsingSongService() throws Exception {
        SongService songService = mock(SongService.class);
        ArrayList<String> songIds = mock(ArrayList.class);
        SongViewModel songViewModel = new SongViewModel(songService);

        ArrayAdapter<Song> adapter = mock(ArrayAdapter.class);

        songViewModel.populateAdapter(songIds, adapter);

        verify(adapter).setNotifyOnChange(true);
        verify(songService).getSongs(songIds, adapter);
    }
}