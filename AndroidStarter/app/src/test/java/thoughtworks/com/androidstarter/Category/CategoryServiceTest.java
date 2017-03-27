package thoughtworks.com.androidstarter.Category;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;

import thoughtworks.com.androidstarter.BuildConfig;
import thoughtworks.com.androidstarter.Category.Category;
import thoughtworks.com.androidstarter.Category.CategoryService;
import thoughtworks.com.androidstarter.HttpService;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Config(constants = BuildConfig.class, sdk = 25)
@RunWith(RobolectricTestRunner.class)
public class CategoryServiceTest {

    private HttpService httpService;
    private CategoryService categoryService;
    private JSONArray jsonArray;
    private ArrayList<Category> actualCategoryList;

    @Before
    public void setUp() throws Exception {
        httpService = mock(HttpService.class);
        categoryService = new CategoryService(httpService);
    }

    @Test
    public void shouldReturnCategoryObjectsFromNonEmptyJSONArray() throws Exception {
        String jsonCategoriesString = "[{'title' : 'Genres', 'id': '1'}," +
                " {'title' : 'Artists', 'id': '2'}," +
                " {'title' : 'Albums', 'id': '3'}]";

        JSONArray jsonArray = new JSONArray(jsonCategoriesString);
        when(httpService.getCategories()).thenReturn(jsonArray);

        categoryService = new CategoryService(httpService);

        actualCategoryList = categoryService.getCategories();

        assertThat(actualCategoryList.get(0).toString(), is(equalTo("Genres")));
        assertThat(actualCategoryList.get(1).getId(), is(equalTo("2")));

    }

    @Test
    public void shouldReturnEmptyCategoryListWhenJSONArrayIsEmpty() throws Exception {
        when(httpService.getCategories()).thenReturn(new JSONArray("[]"));
        categoryService = new CategoryService(httpService);
        ArrayList<Category> actualCategoryList = categoryService.getCategories();

        assertThat(actualCategoryList.size(), is(equalTo(0)));
    }

    @Test
    public void shouldNotCreateNewCategoryFromInvalidJSON() throws Exception {
        JSONObject invalidJSON = new JSONObject("{'name': '','number': ''}");
        Category actualCategory = categoryService.parseCategory(invalidJSON);

        assertNull(actualCategory);
    }

    @Test
    public void shouldCreateCategoryFromValidJSON() throws Exception {
        JSONObject validJSON = new JSONObject("{'title': 'Title', 'id' : '1'}");
        Category actualCategory = categoryService.parseCategory(validJSON);

        assertThat(actualCategory, is(notNullValue()));
    }
}
