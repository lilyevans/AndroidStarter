package thoughtworks.com.androidstarter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        ListView listView = (ListView) findViewById(R.id.category_list_view);
        HttpService httpService = new HttpService();
        CategoryService categoryService = new CategoryService(httpService);

        ArrayList<Category> categories = categoryService.getCategories();
        ArrayAdapter<Category> arrayAdapter = new ArrayAdapter<Category>(this, R.layout.list_item_view, categories);

        listView.setAdapter(arrayAdapter);
    }
}
