package thoughtworks.com.androidstarter.Category;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import thoughtworks.com.androidstarter.BuildConfig;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.isA;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class CategoryViewModelTest {

    private CategoryViewModel viewModel;
    private CategoryService categoryService;

    @Before
    public void setUp() throws Exception {
        categoryService = mock(CategoryService.class);
        viewModel = new CategoryViewModel(categoryService);
    }

    @Test
    public void shouldNotifyAdapterOfDataChangesAndAddCategoriesFromCategoryService() throws Exception {
        ArrayAdapter<Category> adapter = mock(ArrayAdapter.class);

        viewModel.populateAdapter(adapter);

        verify(adapter).setNotifyOnChange(true);
        verify(categoryService).getCategories(adapter);
    }

    @Test
    public void shouldBuildNewCategoryArrayAdapter() throws Exception {
        Context mockContext = mock(Context.class);
        when(mockContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).thenReturn(mock(LayoutInflater.class));

        ArrayAdapter<Category> actualAdapter = viewModel.buildArrayAdapter(mockContext);

        assertThat(actualAdapter, is(instanceOf(ArrayAdapter.class)));
    }

    @Test
    public void shouldBuildOnItemClickListenerForCategories() throws Exception {
        OnCategoryClickListener actualClickListener = viewModel.buildCategoryClickListener();

        assertNotNull(actualClickListener);
        assertThat(actualClickListener, isA(OnCategoryClickListener.class));
    }
}
