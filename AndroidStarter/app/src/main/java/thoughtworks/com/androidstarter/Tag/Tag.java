package thoughtworks.com.androidstarter.Tag;

import java.util.ArrayList;
import java.util.List;

public class Tag {
    private ArrayList<String> songIds;
    private String id;
    private String name;

    public Tag(String name, String id, ArrayList<String> songIds) {
        this.name = name;
        this.id = id;
        this.songIds = songIds;
    }

    public String getName() {
        return name;
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
