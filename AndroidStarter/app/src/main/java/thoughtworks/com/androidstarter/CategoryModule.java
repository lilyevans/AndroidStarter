package thoughtworks.com.androidstarter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import thoughtworks.com.androidstarter.Category.CategoryService;
import thoughtworks.com.androidstarter.Category.CategoryViewModel;

@Module
public class CategoryModule {

    @Provides
    CategoryService providesCategoryService(RetrofitInterface retrofitInterface){
        return new CategoryService(retrofitInterface);
    }

    @Provides
    CategoryViewModel providesCategoryViewModel(CategoryService categoryService){
        return new CategoryViewModel(categoryService);
    }

}
