package thoughtworks.com.androidstarter.Category;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import thoughtworks.com.androidstarter.HttpService;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        HttpService httpService = new HttpService();
        CategoryService categoryService = new CategoryService(httpService);
        CategoryViewModel categoryViewModel = new CategoryViewModel(this, categoryService);

        CategoryView categoryView = new CategoryView(categoryViewModel);
        setContentView(categoryView);
    }
}
