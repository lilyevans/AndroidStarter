package thoughtworks.com.androidstarter.Category;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import thoughtworks.com.androidstarter.R;


public class CategoryViewModel extends ArrayAdapter<Category>{

    private final CategoryService categoryService;
    private Context context;

    public CategoryViewModel(Context context, CategoryService categoryService){
        super(context, R.layout.list_item_view, categoryService.getCategories());
        this.context = context;
        this.categoryService = categoryService;
    }

    public ArrayAdapter<Category> buildArrayAdapter() {
        ArrayList<Category> categories = categoryService.getCategories();
        return new ArrayAdapter<Category>(context, R.layout.list_item_view, categories);
    }

    public OnCategoryClickListener buildCategoryClickListener() {
        return new OnCategoryClickListener();
    }

    public Context getContext(){
        return context;
    }
}
