package thoughtworks.com.androidstarter.services;

import android.widget.Adapter;
import android.widget.AdapterView;

import org.json.JSONArray;

import java.util.ArrayList;

import thoughtworks.com.androidstarter.http.HttpService;
import thoughtworks.com.androidstarter.models.Category;

/**
 * Created by lilyevans on 3/19/17.
 */

public class CategoryService {

    public ArrayList<Category> getCategories() {
        ArrayList<Category> categories = new ArrayList<>();
        JSONArray jsonCategories = HttpService.getCategories();
        //parse json objects to Category and add to arraylist
        //parsing probably extracted to private method

        //mock for now:
        categories.add(new Category("Genres", "1"));
        categories.add(new Category("Artists", "2"));
        categories.add(new Category("Albums", "3"));

        return categories;
    }

}
