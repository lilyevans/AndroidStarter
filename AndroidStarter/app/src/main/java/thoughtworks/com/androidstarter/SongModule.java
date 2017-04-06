package thoughtworks.com.androidstarter;

import android.content.Context;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import thoughtworks.com.androidstarter.Song.SongService;
import thoughtworks.com.androidstarter.Song.SongView;
import thoughtworks.com.androidstarter.Song.SongViewModel;

@Module
public class SongModule {

    @Provides
    public SongService provideSongService(RetrofitInterface retrofitInterface){
        return new SongService(retrofitInterface);
    }

    @Provides
    public SongViewModel provideSongViewModel(SongService songService){
        return new SongViewModel(songService);
    }

    @Provides
    public SongView provideSongView(Context context, ArrayList<String> songIds, SongViewModel songViewModel){
        return new SongView(context, songIds, songViewModel);
    }
}
