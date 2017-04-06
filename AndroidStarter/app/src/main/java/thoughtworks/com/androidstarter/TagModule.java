package thoughtworks.com.androidstarter;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import thoughtworks.com.androidstarter.Tag.TagService;
import thoughtworks.com.androidstarter.Tag.TagView;
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

    @Provides
    TagView provideTagView(Context context, String categoryId, TagViewModel tagViewModel){
        return new TagView(context, categoryId, tagViewModel);
    }
}
