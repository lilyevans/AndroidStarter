package thoughtworks.com.androidstarter;

import javax.inject.Singleton;

import dagger.Component;
import thoughtworks.com.androidstarter.Song.SongActivity;
import thoughtworks.com.androidstarter.Song.SongView;

@Singleton
@Component(modules = {HttpModule.class, SongModule.class, SongActivity.class})
public interface SongComponent {

    SongView provideSongView();
}
