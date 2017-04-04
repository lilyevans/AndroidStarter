package thoughtworks.com.androidstarter.Song;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import thoughtworks.com.androidstarter.R;

public class SongViewModel {
    private Context context;
    private SongService songService;
    private ArrayList<String> songIds;

    public SongViewModel(Context context, SongService songService, ArrayList<String> songIds) {
        this.songService = songService;
        this.context = context;
        this.songIds = songIds;
    }

    public ArrayAdapter<Song> buildArrayAdapter() {
        ArrayAdapter<Song> songArrayAdapter = new ArrayAdapter<Song>(context, R.layout.list_item_view, new ArrayList<Song>());
        songArrayAdapter.setNotifyOnChange(true);
        songService.getSongs(songIds, songArrayAdapter);

        return songArrayAdapter;
    }

    public Context getContext() {
        return context;
    }
}
