package thoughtworks.com.androidstarter.Category;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import thoughtworks.com.androidstarter.R;


public class CategoryViewModel {

    private CategoryService categoryService;
    private Context context;

    public CategoryViewModel(Context context, CategoryService categoryService){
        this.context = context;
        this.categoryService = categoryService;
    }

    public ArrayAdapter<Category> buildArrayAdapter() {
        ArrayList<Category> categories = new ArrayList<Category>();
        ArrayAdapter<Category> categoryAdapter = new ArrayAdapter<Category>(context, R.layout.list_item_view, categories);
        //how do I test this was called?
        categoryAdapter.setNotifyOnChange(true);
        categoryService.getCategories(categoryAdapter);

        return categoryAdapter;
    }

    public OnCategoryClickListener buildCategoryClickListener() {
        return new OnCategoryClickListener();
    }

    public Context getContext(){
        return context;
    }
}
