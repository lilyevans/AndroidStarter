package thoughtworks.com.androidstarter;

import java.util.ArrayList;

/**
 * Created by lilyevans on 3/19/17.
 */

class CategoryService {
    public ArrayList<Category> getCategories() {
        ArrayList<Category> categories = new ArrayList<Category>();
        categories.add(new Category("Genres", "1"));
        categories.add(new Category("Artists", "2"));
        categories.add(new Category("Albums", "3"));

        return categories;
    }
}
