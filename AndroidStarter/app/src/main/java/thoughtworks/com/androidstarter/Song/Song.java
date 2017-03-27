package thoughtworks.com.androidstarter.Song;

public class Song {
    private int id;
    private String type;
    private String description;
    private String coverUrl;
    private String name;

    public Song(int id, String name, String type, String description, String coverUrl){
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.coverUrl = coverUrl;
    }

    @Override
    public String toString() {
        return name;
    }
}
