package thoughtworks.com.androidstarter.Category;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CategoryTest {
    @Test
    public void shouldDisplayCategoryAsCategoryTitle() throws Exception {
        Category category = new Category("Category Title", "1");

        assertThat(category.toString(), is(equalTo("Category Title")));
    }
}