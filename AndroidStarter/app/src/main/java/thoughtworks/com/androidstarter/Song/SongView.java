package thoughtworks.com.androidstarter.Song;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import thoughtworks.com.androidstarter.R;

class SongView extends ListView{
    public SongView(SongViewModel songViewModel) {
        super(songViewModel.getContext());

        ArrayAdapter<Song> songArrayAdapter = songViewModel.buildArrayAdapter();
        songViewModel.populateAdapter(songArrayAdapter);
        setAdapter(songArrayAdapter);

        setId(R.id.song_list_view);
    }
}
