package thoughtworks.com.androidstarter.Category;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import dagger.Module;
import dagger.Provides;
import thoughtworks.com.androidstarter.CategoryComponent;
import thoughtworks.com.androidstarter.DaggerCategoryComponent;
import thoughtworks.com.androidstarter.CategoryModule;

@Module
public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CategoryComponent component = DaggerCategoryComponent.builder().categoryModule(new CategoryModule()).build();
        CategoryView categoryView = component.provideCategoryView();

        setContentView(categoryView);
    }

    @Provides
    public Context provideCategoryActivityContext(){
        return CategoryActivity.this;
    }
}
