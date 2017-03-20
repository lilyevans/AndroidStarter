package thoughtworks.com.androidstarter.http;

import org.json.JSONArray;

import java.util.List;

/**
 * Created by lilyevans on 3/19/17.
 */

public class HttpService {

    public static JSONArray getCategories(){
        //GET request to /api/1/tags
        //Result: Renders a list of objects, each of which has the following fields:
        //title: The tag title (string)
        //id: The tag id (string)

        return null;
    }

    public static JSONArray getTagsFromCategory(String categoryId){
        //GET request to /api/1/category/tag/{tag_id} **looks like I've mixed up tags & categories?
        //Result: Renders a list of objects, each of which has the following fields:
        //name: The category name (string)
        //id: The category id (string)
        //song_ids: The list of songs in the category (list of int)

        return null;
    }

    public static JSONArray getSongsFromIds(List<String> songIds){
        //GET request to  /api/1/songs/multi
        //Optional parameters:
        //id: A song id.  More than one of these can be given. If multiple songs are required, specify id multiple times.
        // ie: /api/1/songs/multi?id=1&id=2
//        Result: Renders a (possibly empty) list of song objects, one for each id parameter.  It is NOT an error for an id to be invalid; any such ids are silently skipped.
//
//        id: integer song id
//        name: song name
//        type: one of {'basic', 'artist', 'stream'
//            description: some descriptive text
//            cover_url: URL for the song's cover art.
        return null;
    }
}
