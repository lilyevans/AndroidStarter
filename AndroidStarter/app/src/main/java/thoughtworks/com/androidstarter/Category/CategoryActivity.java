package thoughtworks.com.androidstarter.Category;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import thoughtworks.com.androidstarter.CategoryComponent;
import thoughtworks.com.androidstarter.DaggerCategoryComponent;
import thoughtworks.com.androidstarter.CategoryModule;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CategoryComponent component = DaggerCategoryComponent.builder().categoryModule(new CategoryModule()).build();
        CategoryViewModel categoryViewModel = component.provideCategoryViewModel();

        CategoryView categoryView = new CategoryView(this, categoryViewModel);
        setContentView(categoryView);
    }
}
