package thoughtworks.com.androidstarter;

import org.json.JSONArray;
import org.json.JSONException;



class HttpService {

    public JSONArray getCategories() {
        //GET to /api/1/tags
        String jsonCategoriesString = "[{'title' : 'Genres', 'id': '1'}," +
                " {'title' : 'Artists', 'id': '2'}," +
                " {'title' : 'Albums', 'id': '3'}]";
        JSONArray jsonCategories;

        try {
            jsonCategories = new JSONArray(jsonCategoriesString);

        } catch (JSONException e) {

            jsonCategories = null;
        }

        return jsonCategories;
    }
}
