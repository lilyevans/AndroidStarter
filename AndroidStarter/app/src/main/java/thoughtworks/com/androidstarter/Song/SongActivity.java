package thoughtworks.com.androidstarter.Song;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import thoughtworks.com.androidstarter.DaggerSongComponent;
import thoughtworks.com.androidstarter.HttpModule;
import thoughtworks.com.androidstarter.SongComponent;
import thoughtworks.com.androidstarter.SongModule;

@Module
public class SongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SongComponent component = DaggerSongComponent.builder().songModule(new SongModule()).build();
        SongView songView = component.provideSongView();

        setContentView(songView);
    }

    @Provides
    public Context provideSongActivityContext(){
        return SongActivity.this;
    }

    @Provides
    public ArrayList<String> provideSongIds(){
        ArrayList<String> songIds = new ArrayList<String>();
        Intent intent = getIntent();

        if (intent.hasExtra("songIDs")){
            songIds = intent.getStringArrayListExtra("songIDs");
        }

        return songIds;
    }
}
