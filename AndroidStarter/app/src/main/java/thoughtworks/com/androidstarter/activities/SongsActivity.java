package thoughtworks.com.androidstarter.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import thoughtworks.com.androidstarter.R;
import thoughtworks.com.androidstarter.models.Song;
import thoughtworks.com.androidstarter.services.SongService;

public class SongsActivity extends AppCompatActivity {

    private ListView listView;
    private SongService songService;

    private Intent intent;
    private ArrayList<Song> songs;
    private ArrayAdapter<Song> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        listView = (ListView) findViewById(R.id.song_list_view);
        songService = new SongService();

        intent = getIntent();

        songs = songService.getSongs(intent.getStringArrayListExtra("songs"));
        arrayAdapter = new ArrayAdapter<Song>(this, R.layout.list_item, songs);

        listView.setAdapter(arrayAdapter);
    }


}
