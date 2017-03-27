package thoughtworks.com.androidstarter.Song;

import android.widget.ListView;

import thoughtworks.com.androidstarter.R;

class SongView extends ListView{
    public SongView(SongViewModel songViewModel) {
        super(songViewModel.getContext());
        setAdapter(songViewModel.buildArrayAdapter());
        setId(R.id.song_list_view);
    }
}
