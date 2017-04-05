package thoughtworks.com.androidstarter.Category;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import thoughtworks.com.androidstarter.HttpService;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CategoryService categoryService = new CategoryService(HttpService.buildRetrofitInterface());
        CategoryViewModel categoryViewModel = new CategoryViewModel(categoryService);

        CategoryView categoryView = new CategoryView(this, categoryViewModel);
        setContentView(categoryView);
    }
}
