package thoughtworks.com.androidstarter.models;


public class Song {
    private String title; //JSON value is "name"
    private String id;
    private String type;
    private String description;
    private String coverURL;

    public Song(String title, String id, String type) {
        this.title = title;
        this.id = id;
        this.type = type;
        this.description = null;
        this.coverURL = null;
    }

    @Override
    public String toString(){
        return title;
    }
}
