package thoughtworks.com.androidstarter.Tag;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class Tag {
    @Expose
    private ArrayList<String> songIds;

    @Expose
    private String id;

    @Expose
    private String name;

    public Tag(){

    }

    public Tag(String name, String id, ArrayList<String> songIds) {
        this.name = name;
        this.id = id;
        this.songIds = songIds;
    }

    public String getId() {
        return id;
    }

    public ArrayList<String> getSongIds() {
        return songIds;
    }

    @Override
    public String toString(){
        return name;
    }
}
