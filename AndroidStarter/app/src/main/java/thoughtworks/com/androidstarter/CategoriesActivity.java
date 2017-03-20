package thoughtworks.com.androidstarter;

import android.content.Intent;
import android.icu.util.ULocale;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class CategoriesActivity extends AppCompatActivity {

    private ListView listView;
    private CategoryService categoryService;

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Category category = (Category) parent.getItemAtPosition(position);
            Intent intent = new Intent(parent.getContext(), TagsActivity.class);
            intent.putExtra("categoryID", category.getID());

            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        listView = (ListView) findViewById(R.id.category_list_view);
        categoryService = new CategoryService();

        ArrayList<Category> categories = categoryService.getCategories();

        ArrayAdapter<Category> arrayAdapter = new ArrayAdapter<Category>(this, R.layout.list_item, categories);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(onItemClickListener);

    }


}
