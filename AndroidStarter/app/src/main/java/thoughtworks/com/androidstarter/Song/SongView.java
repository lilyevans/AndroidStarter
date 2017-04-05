package thoughtworks.com.androidstarter.Song;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import thoughtworks.com.androidstarter.R;

class SongView extends ListView{
    public SongView(Context context, SongViewModel songViewModel) {
        super(context);

        ArrayAdapter<Song> songArrayAdapter = songViewModel.buildArrayAdapter(context);
        songViewModel.populateAdapter(songArrayAdapter);
        setAdapter(songArrayAdapter);

        setId(R.id.song_list_view);
    }
}
