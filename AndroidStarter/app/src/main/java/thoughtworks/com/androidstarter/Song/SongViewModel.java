package thoughtworks.com.androidstarter.Song;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import thoughtworks.com.androidstarter.R;

public class SongViewModel {
    private SongService songService;
    private ArrayList<String> songIds;

    public SongViewModel(SongService songService, ArrayList<String> songIds) {
        this.songService = songService;
        this.songIds = songIds;
    }

    public ArrayAdapter<Song> buildArrayAdapter(Context context) {
        ArrayAdapter<Song> songArrayAdapter = new ArrayAdapter<Song>(context, R.layout.list_item_view, new ArrayList<Song>());

        return songArrayAdapter;
    }

    public void populateAdapter(ArrayAdapter<Song> songArrayAdapter) {
        songArrayAdapter.setNotifyOnChange(true);
        songService.getSongs(songIds, songArrayAdapter);
    }
}
