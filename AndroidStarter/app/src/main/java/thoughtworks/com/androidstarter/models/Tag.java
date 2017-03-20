package thoughtworks.com.androidstarter.models;


import java.util.ArrayList;
import java.util.List;

public class Tag {
    private String name;
    private String id;
    private ArrayList<String> songsWithTag;

    public Tag(String name, String id, ArrayList<String> songsWithTag){
        this.name = name;
        this.id = id;
        this.songsWithTag = songsWithTag;
    }

    public ArrayList<String> getSongsWithTag(){
        return songsWithTag;
    }

    @Override
    public String toString(){
        return name;
    }
}
