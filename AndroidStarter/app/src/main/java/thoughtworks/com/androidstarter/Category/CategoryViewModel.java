package thoughtworks.com.androidstarter.Category;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import thoughtworks.com.androidstarter.R;


public class CategoryViewModel {

    private CategoryService categoryService;

    public CategoryViewModel(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    public ArrayAdapter<Category> buildArrayAdapter(Context context) {
        ArrayList<Category> categories = new ArrayList<Category>();
        ArrayAdapter<Category> categoryAdapter = new ArrayAdapter<Category>(context, R.layout.list_item_view, categories);

        return categoryAdapter;
    }

    public void populateAdapter(ArrayAdapter<Category> categoryAdapter) {
        categoryAdapter.setNotifyOnChange(true);
        categoryService.getCategories(categoryAdapter);
    }

    public OnCategoryClickListener buildCategoryClickListener() {
        return new OnCategoryClickListener();
    }
}
