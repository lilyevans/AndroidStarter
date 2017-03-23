package thoughtworks.com.androidstarter.Tag;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import thoughtworks.com.androidstarter.HttpService;

public class TagService {

    private HttpService httpService;

    public TagService(HttpService httpService){
        this.httpService = httpService;
    }

    public ArrayList<Tag> getTags(String categoryId) {
        JSONArray jsonTags = httpService.getTags(categoryId);
        ArrayList<Tag> tags = new ArrayList<Tag>();

        for (int i = 0; i < jsonTags.length(); i++){
            Tag tag = parseTag(jsonTags.optJSONObject(i));
            if (tag != null){
                tags.add(tag);
            }
        }

        return tags;
    }

    public Tag parseTag(JSONObject json) {
        Tag tag = null;
        if (json.has("name") && json.has("id") && json.has("song_ids")){
            String name = json.optString("name");
            String id = json.optString("id");
            ArrayList<String> songIds = new ArrayList<String>();

            for (int i = 0; i < json.optJSONArray("song_ids").length(); i++){
                songIds.add(String.valueOf(json.optJSONArray("song_ids").optInt(i)));
            }
            tag = new Tag(name, id, songIds);
        }
        return tag;
    }
}
