package thoughtworks.com.androidstarter.Category;

import android.widget.ArrayAdapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import thoughtworks.com.androidstarter.BuildConfig;

import static org.hamcrest.Matchers.isA;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
    public void name() throws Exception {

    }

    @Test
    public void shouldBuildArrayAdapterWithCategoriesFromCategoryService() throws Exception {
        viewModel = new CategoryViewModel(categoryActivity, categoryService);

        ArrayAdapter<Category> actualAdapter = viewModel.buildArrayAdapter();

        verify(categoryService).getCategories(Matchers.any(ArrayAdapter.class));
    }

    @Test
    public void shouldBuildOnItemClickListenerForCategories() throws Exception {
        viewModel = new CategoryViewModel(categoryActivity, categoryService);
        OnCategoryClickListener actualClickListener = viewModel.buildCategoryClickListener();

        assertNotNull(actualClickListener);
        assertThat(actualClickListener, isA(OnCategoryClickListener.class));

    }
}
