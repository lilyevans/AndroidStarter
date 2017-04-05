package thoughtworks.com.androidstarter.Song;

import android.widget.ArrayAdapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import thoughtworks.com.androidstarter.BuildConfig;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Config(constants = BuildConfig.class, sdk = 25)
@RunWith(RobolectricTestRunner.class)
public class SongViewTest {

    private SongViewModel songViewModel;
    private SongActivity songActivity;
    private ArrayAdapter<Song> mockAdapter;
    private SongView songView;

    @Before
    public void setUp() throws Exception {
        songViewModel = mock(SongViewModel.class);
        songActivity = Robolectric.buildActivity(SongActivity.class).get();

        mockAdapter = mock(ArrayAdapter.class);
        when(mockAdapter.getViewTypeCount()).thenReturn(1);
        when(songViewModel.buildArrayAdapter(songActivity)).thenReturn(mockAdapter);

        songView = new SongView(songActivity, songViewModel);
    }

    @Test
    public void shouldBuildArrayAdapterUsingSongViewModel() throws Exception {
        verify(songViewModel).buildArrayAdapter(songActivity);
    }

    @Test
    public void shouldPrepareAndPopulateArrayAdaoterUsingSongViewModel() throws Exception {
        verify(songViewModel).populateAdapter(mockAdapter);
    }

    @Test
    public void shouldViewsArrayAdapterToBeAdapterBuiltAndPreparedBySongViewModel() throws Exception {
        ArrayAdapter<Song> actualAdapter = (ArrayAdapter<Song>) songView.getAdapter();

        assertThat(actualAdapter, is(equalTo(mockAdapter)));
    }
}