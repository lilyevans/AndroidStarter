package thoughtworks.com.androidstarter.services;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import thoughtworks.com.androidstarter.http.HttpService;
import thoughtworks.com.androidstarter.models.Tag;

public class TagService {
    public ArrayList<Tag> getTagsByCategoryID(String categoryID) {
        ArrayList<Tag> tags = new ArrayList<Tag>();
        JSONArray jsonTags = HttpService.getTagsFromCategory(categoryID);
        //parse json to tags and add to array

        //mock data for now:
        ArrayList<String> songIds = new ArrayList<String>();
        songIds.add("1");

        switch(categoryID){
            case "1":
                tags.add(new Tag("Hip Hop", "1", songIds));
                break;
            case "2":
                tags.add(new Tag("Vince Staples", "1", songIds));
                break;
            case "3":
                tags.add(new Tag("Summertime '06", "1", songIds));
                break;
            default:
                break;
        }

        return tags;
    }

}
