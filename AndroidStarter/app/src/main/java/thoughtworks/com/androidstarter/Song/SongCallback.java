package thoughtworks.com.androidstarter.Song;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class SongCallback implements Callback<List<Song>> {
    private ArrayAdapter<Song> songArrayAdapter;
    private ArrayList<Song> songs;

    public SongCallback(ArrayAdapter<Song> songArrayAdapter) {
        this.songArrayAdapter = songArrayAdapter;
        this.songs = new ArrayList<Song>();
    }

    @Override
    public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
        if (response.isSuccessful()){
            for (Song song : response.body()){
                songs.add(song);
            }

            songArrayAdapter.addAll(songs);
        }
    }

    @Override
    public void onFailure(Call<List<Song>> call, Throwable t) {

    }
}
