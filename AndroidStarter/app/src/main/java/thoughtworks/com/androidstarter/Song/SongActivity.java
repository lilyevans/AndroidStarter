package thoughtworks.com.androidstarter.Song;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import thoughtworks.com.androidstarter.HttpService;
import thoughtworks.com.androidstarter.R;

public class SongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        HttpService httpService = new HttpService();
        SongService songService = new SongService(httpService.buildRetrofitInterface());
        SongViewModel songViewModel = new SongViewModel(this, songService, intent.getStringArrayListExtra("songIDs"));
        SongView songView = new SongView(songViewModel);

        setContentView(songView);
    }
}
