package thoughtworks.com.androidstarter;

import javax.inject.Singleton;

import dagger.Component;
import thoughtworks.com.androidstarter.Category.CategoryViewModel;

@Singleton
@Component(modules = {CategoryModule.class, HttpModule.class})
public interface CategoryComponent {

    CategoryViewModel provideCategoryViewModel();
}
