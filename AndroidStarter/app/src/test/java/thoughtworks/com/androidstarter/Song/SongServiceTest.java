package thoughtworks.com.androidstarter.Song;

import org.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;

import thoughtworks.com.androidstarter.BuildConfig;
import thoughtworks.com.androidstarter.HttpService;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Config(constants = BuildConfig.class, sdk = 25)
@RunWith(RobolectricTestRunner.class)
public class SongServiceTest {
    @Test
    public void shouldBuildEmptyArrayListWhenJSONArrayIsEmpty() throws Exception {
        JSONArray jsonArray = new JSONArray("[]");
        HttpService httpService = mock(HttpService.class);
        when(httpService.getSongs(Matchers.any(ArrayList.class))).thenReturn(jsonArray);

        SongService songService = new SongService(httpService);

        ArrayList<Song> actualSongs = songService.getSongs(new ArrayList<String>());

        assertThat(actualSongs.size(), is(equalTo(0)));
    }

    @Test
    public void shouldReturnArrayListOfSongsWhenJSONArrayIsNotEmpty() throws Exception {
        String jsonString = "[{'id':1,'name':'Norf Norf'," +
                "'type':'basic','description':'some descriptive text', " +
                "'cover_url': 'http://www.somecoverurl.com/img.jpg'}]";
        JSONArray jsonArray = new JSONArray(jsonString);
        HttpService httpService = mock(HttpService.class);
        when(httpService.getSongs(Matchers.any(ArrayList.class))).thenReturn(jsonArray);

        SongService songService = new SongService(httpService);
        ArrayList<Song> actualSongs  = songService.getSongs(new ArrayList<String>());

        assertThat(actualSongs.size(), is(equalTo(1)));
        assertThat(actualSongs.get(0).toString(), is(equalTo("Norf Norf")));
    }
}