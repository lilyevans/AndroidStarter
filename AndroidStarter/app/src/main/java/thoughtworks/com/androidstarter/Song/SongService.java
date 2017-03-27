package thoughtworks.com.androidstarter.Song;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import thoughtworks.com.androidstarter.HttpService;

class SongService {
    private HttpService httpService;

    public SongService(HttpService httpService) {
        this.httpService = httpService;
    }

    public ArrayList<Song> getSongs(ArrayList<String> songIds) {
        JSONArray jsonArray = httpService.getSongs(songIds);
        ArrayList<Song> songs = new ArrayList<Song>();

        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject json = jsonArray.optJSONObject(i);
            int id = json.optInt("id");
            String name = json.optString("name");
            String type = json.optString("type");
            String description = json.optString("description");
            String coverUrl = json.optString("cover_url");
            songs.add(new Song(id, name, type, description, coverUrl));
        }

        return songs;
    }
}
