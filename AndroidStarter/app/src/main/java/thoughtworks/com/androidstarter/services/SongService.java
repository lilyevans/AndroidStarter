package thoughtworks.com.androidstarter.services;

import org.json.JSONArray;

import java.util.ArrayList;

import thoughtworks.com.androidstarter.http.HttpService;
import thoughtworks.com.androidstarter.models.Song;

/**
 * Created by lilyevans on 3/20/17.
 */

public class SongService {
    public ArrayList<Song> getSongs(ArrayList<String> songIds) {
        ArrayList<Song> songs = new ArrayList<Song>();
        JSONArray jsonSongs = HttpService.getSongsFromIds(songIds);
        //parse json into songs

        //mock data for now:
        songs.add(new Song("Norf Norf", "1", "basic"));

        return songs;
    }
}
