package thoughtworks.com.androidstarter;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Config(constants = BuildConfig.class, sdk = 25)
@RunWith(RobolectricTestRunner.class)
public class CategoryServiceTest {

    @Test
    public void shouldReturnCategoryObjectsFromNonEmptyJSONArray() throws Exception {
        String jsonCategoriesString = "[{'title' : 'Genres', 'id': '1'}," +
                " {'title' : 'Artists', 'id': '2'}," +
                " {'title' : 'Albums', 'id': '3'}]";
        HttpService httpService = mock(HttpService.class);
        JSONArray jsonArray = new JSONArray(jsonCategoriesString);
        when(httpService.getCategories()).thenReturn(jsonArray);

        CategoryService categoryService = new CategoryService(httpService);

        ArrayList<Category> actualCategoryList = categoryService.getCategories();

        assertThat(actualCategoryList.get(0).getTitle(), is(equalTo("Genres")));
        assertThat(actualCategoryList.get(1).getId(), is(equalTo("2")));

    }
}
