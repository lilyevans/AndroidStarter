package thoughtworks.com.androidstarter.Category;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import thoughtworks.com.androidstarter.HttpService;


public class CategoryService {

    private HttpService httpService;

    public CategoryService(HttpService httpService) {
        this.httpService = httpService;
    }

    public ArrayList<Category> getCategories() {
        JSONArray categoriesJSON = httpService.getCategories();
        ArrayList<Category> categories = new ArrayList<Category>();

        for (int i = 0; i < categoriesJSON.length(); i++){
            Category categoryFromJSON = parseCategory(categoriesJSON.optJSONObject(i));
            if (categoryFromJSON != null){
                categories.add(categoryFromJSON);
            }
        }

        return categories;
    }

    public Category parseCategory(JSONObject json) {
        Category category = null;

        if (json.has("title") && json.has("id")){
            category = new Category(json.optString("title"), json.optString("id"));
        }

        return category;
    }
}
