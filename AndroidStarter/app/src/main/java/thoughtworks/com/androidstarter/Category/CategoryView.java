package thoughtworks.com.androidstarter.Category;

import android.widget.ListView;


public class CategoryView extends ListView {
    public CategoryView(CategoryViewModel categoryViewModel) {
        super(categoryViewModel.getContext());
        setAdapter(categoryViewModel.buildArrayAdapter());
        setOnItemClickListener(categoryViewModel.buildCategoryClickListener());
    }
}
