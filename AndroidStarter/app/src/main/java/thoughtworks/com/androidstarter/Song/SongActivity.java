package thoughtworks.com.androidstarter.Song;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import thoughtworks.com.androidstarter.DaggerSongComponent;
import thoughtworks.com.androidstarter.SongComponent;
import thoughtworks.com.androidstarter.SongModule;

public class SongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SongComponent component = DaggerSongComponent.builder().songModule(new SongModule()).build();
        SongViewModel songViewModel = component.provideSongViewModel();
        SongView songView = new SongView(this, getSongIds(), songViewModel);

        setContentView(songView);
    }

    private ArrayList<String> getSongIds(){
        ArrayList<String> songIds = new ArrayList<String>();
        Intent intent = getIntent();

        if (intent.hasExtra("songIDs")){
            songIds = intent.getStringArrayListExtra("songIDs");
        }

        return songIds;
    }
}
