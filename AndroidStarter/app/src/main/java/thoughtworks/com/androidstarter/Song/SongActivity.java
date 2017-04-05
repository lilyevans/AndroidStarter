package thoughtworks.com.androidstarter.Song;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import thoughtworks.com.androidstarter.HttpService;

public class SongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        SongService songService = new SongService(HttpService.buildRetrofitInterface());
        SongViewModel songViewModel = new SongViewModel(songService, intent.getStringArrayListExtra("songIDs"));
        SongView songView = new SongView(this, songViewModel);

        setContentView(songView);
    }
}
