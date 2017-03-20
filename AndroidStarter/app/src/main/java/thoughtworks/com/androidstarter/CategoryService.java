package thoughtworks.com.androidstarter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


class CategoryService {

    private HttpService httpService;

    public CategoryService(HttpService httpService) {
        this.httpService = httpService;
    }

    public ArrayList<Category> getCategories() {
        JSONArray categoriesJSON = httpService.getCategories();
        ArrayList<Category> categories = new ArrayList<Category>();

        for (int i = 0; i < categoriesJSON.length(); i++){
                JSONObject objectFromArray = categoriesJSON.optJSONObject(i);
                Category categoryFromJSON = new Category(objectFromArray.optString("title"), objectFromArray.optString("id"));
                categories.add(categoryFromJSON);
        }

        return categories;
    }

}
