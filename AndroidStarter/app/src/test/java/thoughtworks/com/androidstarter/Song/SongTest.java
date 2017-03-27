package thoughtworks.com.androidstarter.Song;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.robolectric.annotation.Config;

import thoughtworks.com.androidstarter.BuildConfig;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
@Config(constants = BuildConfig.class, sdk = 25)
@RunWith(JUnit4.class)
public class SongTest {
    @Test
    public void shouldDisplaySongName() throws Exception {
        Song song = new Song(1, "Norf Norf", "", "", "");

        assertThat(song.toString(), is(equalTo("Norf Norf")));
    }
}