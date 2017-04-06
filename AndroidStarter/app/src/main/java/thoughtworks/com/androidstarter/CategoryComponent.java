package thoughtworks.com.androidstarter;

import javax.inject.Singleton;

import dagger.Component;
import thoughtworks.com.androidstarter.Category.CategoryActivity;
import thoughtworks.com.androidstarter.Category.CategoryView;

@Singleton
@Component(modules = {CategoryModule.class, CategoryActivity.class, HttpModule.class})
public interface CategoryComponent {

    CategoryView provideCategoryView();

}
