package thoughtworks.com.androidstarter.Category;

import android.widget.ListView;

import thoughtworks.com.androidstarter.R;


public class CategoryView extends ListView {
    public CategoryView(CategoryViewModel categoryViewModel) {
        super(categoryViewModel.getContext());
        setAdapter(categoryViewModel.buildArrayAdapter());
        setOnItemClickListener(categoryViewModel.buildCategoryClickListener());
        setId(R.id.category_list_view);
    }
}
