package thoughtworks.com.androidstarter.Song;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import thoughtworks.com.androidstarter.RetrofitInterface;

public class SongService {
    private RetrofitInterface retrofitInterface;

    @Inject
    public SongService(RetrofitInterface retrofitInterface) {
        this.retrofitInterface = retrofitInterface;
    }

    public void getSongs(ArrayList<String> songIds, ArrayAdapter<Song> songArrayAdapter) {
        Call<List<Song>> call = retrofitInterface.getSongs(songIds);
        call.enqueue(new SongCallback(songArrayAdapter));
    }
}
