package thoughtworks.com.androidstarter.models;


public class Category {
    private String title;
    private String id;

    public Category(String title, String id){
        this.title = title;
        this.id = id;
    }

    @Override
    public String toString(){
        return title;
    }

    public String getID() {
        return id;
    }
}
