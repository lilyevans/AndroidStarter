package thoughtworks.com.androidstarter;

import javax.inject.Singleton;

import dagger.Component;
import thoughtworks.com.androidstarter.Tag.TagActivity;
import thoughtworks.com.androidstarter.Tag.TagView;
import thoughtworks.com.androidstarter.Tag.TagViewModel;

@Singleton
@Component(modules = {TagModule.class, TagActivity.class, HttpModule.class})
public interface TagComponent {

    TagView provideTagView();
    
}
