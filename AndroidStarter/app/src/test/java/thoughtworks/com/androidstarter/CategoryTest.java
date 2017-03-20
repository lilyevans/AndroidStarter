package thoughtworks.com.androidstarter;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by lilyevans on 3/19/17.
 */
public class CategoryTest {
    @Test
    public void shouldDisplayCategoryTitle() throws Exception {
        String title = "Category Title";
        String id = "1";
        Category category = new Category(title, id);

        assertThat(category.toString(), is(equalTo(title)));

    }
}