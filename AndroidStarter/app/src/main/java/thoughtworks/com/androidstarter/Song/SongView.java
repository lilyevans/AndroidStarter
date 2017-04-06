package thoughtworks.com.androidstarter.Song;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import javax.inject.Inject;

import thoughtworks.com.androidstarter.R;

public class SongView extends ListView{
    @Inject
    public SongView(Context context, SongViewModel songViewModel) {
        super(context);

        ArrayAdapter<Song> songArrayAdapter = songViewModel.buildArrayAdapter(context);
        songViewModel.populateAdapter(songArrayAdapter);
        setAdapter(songArrayAdapter);

        setId(R.id.song_list_view);
    }
}
