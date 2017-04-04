package thoughtworks.com.androidstarter.Category;


import com.google.gson.annotations.Expose;

public class Category {

    @Expose
    private String title;

    @Expose
    private String id;

    public Category(){

    }

    public Category(String title, String id){
        this.title = title;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString(){
        return title;
    }
}
