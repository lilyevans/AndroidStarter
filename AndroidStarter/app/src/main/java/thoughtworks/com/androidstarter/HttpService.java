package thoughtworks.com.androidstarter;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;


public class HttpService {

    public JSONArray getCategories() {
        //GET to /api/1/tags
        String jsonCategoriesString = "[{'title' : 'Genres', 'id': '1'}," +
                " {'title' : 'Artists', 'id': '2'}," +
                " {'title' : 'Albums', 'id': '3'}]";
        JSONArray jsonCategories;

        try {
            jsonCategories = new JSONArray(jsonCategoriesString);

        } catch (JSONException e) {

            jsonCategories = new JSONArray();
        }

        return jsonCategories;
    }

    public JSONArray getTags(String categoryId) {
        //GET /api//api/1/category/tag/{tag_id} **reverse tags & categories
        //name: The category name (string)
        //id: The category id (string)
        //song_ids: The list of songs in the category (list of int)
        JSONArray jsonTags;

        String jsonTagsString = "[{'name':'Hell Can Wait', 'id':'1', 'song_ids':[1]}," +
                " {'name':'Summertime 06', 'id':'2', 'song_ids':[2,3]}," +
                " {'name':'Prima Donna', 'id':'3', 'song_ids':[4,5]}]";
        try {
            jsonTags = new JSONArray(jsonTagsString);
        } catch (JSONException e) {
            e.printStackTrace();
            jsonTags = new JSONArray();
        }

        return jsonTags;
    }

    public JSONArray getSongs(ArrayList<String> songIds) {
        JSONArray jsonSongs;
        String jsonSongsString = "[{'id':1,'name':'Norf Norf'," +
                "'type':'basic','description':'some descriptive text', " +
                "'cover_url': 'http://www.somecoverurl.com/img.jpg'}, " +
                "{'id':2,'name':'Jump Off The Roof'," +
                "'type':'basic','description':'some descriptive text', " +
                "'cover_url': 'http://www.somecoverurl.com/img.jpg'}, " +
                "{'id':3,'name':'Birds & Bees'," +
                "'type':'basic','description':'some descriptive text', " +
                "'cover_url': 'http://www.somecoverurl.com/img.jpg'}]";

        try {
            jsonSongs = new JSONArray(jsonSongsString);
        } catch (JSONException e) {
            e.printStackTrace();
            jsonSongs = null;
        }
        return jsonSongs;
    }

// getSongs:
// GET /api/1/songs/multi
//
//    id: A song id.  More than one of these can be given. If multiple songs are required, specify id multiple times.
//    ie: /api/1/songs/multi?id=1&id=2
//
//    Result: Renders a (possibly empty) list of song objects, one for each id parameter.  It is NOT an error for an id to be invalid; any such ids are silently skipped.
//
//    id: integer song id
//    name: song name
//    type: one of {'basic', 'artist', 'stream'
//    description: some descriptive text
//    cover_url: URL for the song's cover art.






}
