package thoughtworks.com.androidstarter.Song;

import android.content.Context;
import android.widget.ArrayAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import thoughtworks.com.androidstarter.HttpService;
import thoughtworks.com.androidstarter.RetrofitInterface;

class SongService {
    private RetrofitInterface retrofitInterface;

    public SongService(RetrofitInterface retrofitInterface) {
        this.retrofitInterface = retrofitInterface;
    }

    public void getSongs(ArrayList<String> songIds, ArrayAdapter<Song> songArrayAdapter) {
        Call<List<Song>> call = retrofitInterface.getSongs(songIds);
        call.enqueue(new SongCallback(songArrayAdapter));
    }
}
