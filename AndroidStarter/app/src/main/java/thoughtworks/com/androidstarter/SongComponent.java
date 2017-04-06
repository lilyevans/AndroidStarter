package thoughtworks.com.androidstarter;

import javax.inject.Singleton;

import dagger.Component;
import thoughtworks.com.androidstarter.Song.SongViewModel;

@Singleton
@Component(modules = {HttpModule.class, SongModule.class})
public interface SongComponent {

    SongViewModel provideSongViewModel();
}
