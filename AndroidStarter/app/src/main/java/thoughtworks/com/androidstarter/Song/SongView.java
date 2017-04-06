package thoughtworks.com.androidstarter.Song;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import thoughtworks.com.androidstarter.R;

public class SongView extends ListView{
    public SongView(Context context, ArrayList<String> songIds, SongViewModel songViewModel) {
        super(context);

        ArrayAdapter<Song> songArrayAdapter = songViewModel.buildArrayAdapter(context);
        songViewModel.populateAdapter(songIds, songArrayAdapter);
        setAdapter(songArrayAdapter);

        setId(R.id.song_list_view);
    }
}
