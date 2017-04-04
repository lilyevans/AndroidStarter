package thoughtworks.com.androidstarter;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.action.KeyEventAction;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import thoughtworks.com.androidstarter.Category.Category;
import thoughtworks.com.androidstarter.Category.CategoryActivity;

import static android.support.test.InstrumentationRegistry.getContext;


public class CategoryViewIdlingResource implements IdlingResource {
    private CategoryActivity activity;
    private ResourceCallback resourceCallback;
    private boolean isIdle;

    public CategoryViewIdlingResource(CategoryActivity activity){
        this.activity = activity;
    }
    @Override
    public String getName() {
        return "Category View Idling Resource";
    }

    @Override
    public boolean isIdleNow() {
        if (activity == null) return false;
        ListView categoryListView = (ListView) activity.findViewById(R.id.category_list_view);
        ArrayAdapter<Category> categoryArrayAdapter = (ArrayAdapter<Category>) categoryListView.getAdapter();


        isIdle = !categoryArrayAdapter.isEmpty();

        if (isIdle) {
            resourceCallback.onTransitionToIdle();
        }

        return isIdle;
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        this.resourceCallback = callback;
    }


}
