package thoughtworks.com.androidstarter.Category;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;

import thoughtworks.com.androidstarter.BuildConfig;
import thoughtworks.com.androidstarter.Category.Category;
import thoughtworks.com.androidstarter.Category.CategoryActivity;
import thoughtworks.com.androidstarter.Category.CategoryService;
import thoughtworks.com.androidstarter.Category.CategoryViewModel;
import thoughtworks.com.androidstarter.Category.OnCategoryClickListener;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isA;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Config(constants = BuildConfig.class, sdk = 25)
@RunWith(RobolectricTestRunner.class)
public class CategoryViewModelTest {

    private CategoryActivity categoryActivity;
    private CategoryViewModel viewModel;
    private CategoryService categoryService;

    @Before
    public void setUp() throws Exception {
        categoryActivity = Robolectric.buildActivity(CategoryActivity.class).get();
        categoryService = mock(CategoryService.class);
    }

    @Test
    public void shouldBuildArrayAdapterWithCategoriesFromCategoryService() throws Exception {
        Category category = mock(Category.class);
        ArrayList<Category> mockCategories = new ArrayList<Category>();
        mockCategories.add(category);

        when(categoryService.getCategories()).thenReturn(mockCategories);

        viewModel = new CategoryViewModel(categoryActivity, categoryService);

        ArrayAdapter<Category> actualAdapter = viewModel.buildArrayAdapter();

        assertThat(actualAdapter.getItem(0), is(equalTo(category)));
    }

    @Test
    public void shouldBuildOnItemClickListenerForCategories() throws Exception {
        viewModel = new CategoryViewModel(categoryActivity, categoryService);
        OnCategoryClickListener actualClickListener = viewModel.buildCategoryClickListener();

        assertNotNull(actualClickListener);
        assertThat(actualClickListener, isA(OnCategoryClickListener.class));

    }
}
