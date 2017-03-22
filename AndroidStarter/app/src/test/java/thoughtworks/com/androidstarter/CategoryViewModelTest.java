package thoughtworks.com.androidstarter;

import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isA;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.robolectric.Shadows.shadowOf;

@Config(constants = BuildConfig.class, sdk = 25)
@RunWith(RobolectricTestRunner.class)
public class CategoryViewModelTest {
    @Test
    public void shouldBuildArrayAdapterWithTypeCategory() throws Exception {
        CategoryActivity categoryActivity = Robolectric.buildActivity(CategoryActivity.class).get();

        CategoryService categoryService = mock(CategoryService.class);
        CategoryViewModel viewModel = new CategoryViewModel(categoryActivity, categoryService);

        ArrayAdapter<Category> actualAdapter = viewModel.buildArrayAdapter();
        assertThat(actualAdapter.getItem(0), isA(Category.class));
    }

    @Test
    public void shouldBuildArrayAdapterWithCategoriesFromCategoryService() throws Exception {
        CategoryActivity categoryActivity = Robolectric.buildActivity(CategoryActivity.class).get();

        Category category = mock(Category.class);
        ArrayList<Category> mockCategories = new ArrayList<Category>();
        mockCategories.add(category);

        CategoryService categoryService = mock(CategoryService.class);
        when(categoryService.getCategories()).thenReturn(mockCategories);

        CategoryViewModel viewModel = new CategoryViewModel(categoryActivity, categoryService);

        ArrayAdapter<Category> actualAdapter = viewModel.buildArrayAdapter();

        assertThat(actualAdapter.getItem(0), is(equalTo(category)));

    }
}
