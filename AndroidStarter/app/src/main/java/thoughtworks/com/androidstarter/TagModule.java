package thoughtworks.com.androidstarter;

import dagger.Module;
import dagger.Provides;
import thoughtworks.com.androidstarter.Tag.TagService;
import thoughtworks.com.androidstarter.Tag.TagViewModel;

@Module
public class TagModule {

    @Provides
    TagService provideTagService(RetrofitInterface retrofitInterface){
        return new TagService(retrofitInterface);
    }

    @Provides
    TagViewModel provideTagViewModel(TagService tagService){
        return new TagViewModel(tagService);
    }
}
