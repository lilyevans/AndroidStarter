package thoughtworks.com.androidstarter.Category;

import android.content.Context;
import android.widget.ListView;

/**
 * Created by lilyevans on 3/22/17.
 */

public class CategoryView extends ListView {
    public CategoryView(CategoryViewModel categoryViewModel) {
        super(categoryViewModel.getContext());
        setAdapter(categoryViewModel.buildArrayAdapter());
        setOnItemClickListener(new OnCategoryClickListener());
    }
}
