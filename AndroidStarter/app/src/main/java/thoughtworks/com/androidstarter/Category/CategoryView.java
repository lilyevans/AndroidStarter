package thoughtworks.com.androidstarter.Category;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import javax.inject.Inject;

import thoughtworks.com.androidstarter.R;


public class CategoryView extends ListView {
    @Inject
    public CategoryView(Context context, CategoryViewModel categoryViewModel) {
        super(context);

        ArrayAdapter<Category> categoryAdapter = categoryViewModel.buildArrayAdapter(context);
        categoryViewModel.populateAdapter(categoryAdapter);
        setAdapter(categoryAdapter);

        setOnItemClickListener(categoryViewModel.buildCategoryClickListener());

        setId(R.id.category_list_view);
    }
}
