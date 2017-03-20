package thoughtworks.com.androidstarter.models;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SongTest {
    @Test
    public void shouldDisplaySongTitle() throws Exception {
        String songTitle = "Song Title";
        Song song = new Song(songTitle, "1", "basic");

        assertThat(song.toString(), is(equalTo(songTitle)));
    }
}