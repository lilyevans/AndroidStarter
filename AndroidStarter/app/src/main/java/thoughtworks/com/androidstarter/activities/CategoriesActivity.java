package thoughtworks.com.androidstarter.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import thoughtworks.com.androidstarter.R;
import thoughtworks.com.androidstarter.models.Category;
import thoughtworks.com.androidstarter.services.CategoryService;

public class CategoriesActivity extends AppCompatActivity {

    private ListView listView;
    private CategoryService categoryService;

    private ArrayList<Category> categories;
    private ArrayAdapter<Category> arrayAdapter;
    private AdapterView.OnItemClickListener onItemClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        listView = (ListView) findViewById(R.id.category_list_view);
        categoryService = new CategoryService();
        onItemClickListener = new OnCategoryItemClickListener();
        categories = categoryService.getCategories();
        arrayAdapter = new ArrayAdapter<Category>(this, R.layout.list_item, categories);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(onItemClickListener);
    }


}
