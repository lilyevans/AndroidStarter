package thoughtworks.com.androidstarter;


public class Category {

    private String title;
    private String id;

    public Category(String title, String id){
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString(){
        return title;
    }

}
