package thoughtworks.com.androidstarter;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;


class CategoryViewModel {

    private final CategoryService categoryService;
    private Context context;

    public CategoryViewModel(Context context, CategoryService categoryService){
        this.context = context;
        this.categoryService = categoryService;
    }

    public ArrayAdapter<Category> buildArrayAdapter() {
        ArrayList<Category> categories = new ArrayList<Category>();
        categories.add(new Category("title", "id"));

        return new ArrayAdapter<Category>(context, R.layout.list_item_view, categories);
    }
}
