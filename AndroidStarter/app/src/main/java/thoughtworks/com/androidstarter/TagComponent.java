package thoughtworks.com.androidstarter;

import javax.inject.Singleton;

import dagger.Component;
import thoughtworks.com.androidstarter.Tag.TagViewModel;

@Singleton
@Component(modules = {TagModule.class, HttpModule.class})
public interface TagComponent {

    TagViewModel provideTagViewModel();
}
