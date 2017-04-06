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
    TagViewModel provideTagViewModel(TagService tagService, String categoryId){
        return new TagViewModel(tagService, categoryId);
    }

    @Provides
    TagView provideTagView(Context context, TagViewModel tagViewModel){
        return new TagView(context, tagViewModel);
    }
}
