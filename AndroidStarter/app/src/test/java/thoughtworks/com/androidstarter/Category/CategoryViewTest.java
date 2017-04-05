package thoughtworks.com.androidstarter.Category;

import android.widget.ArrayAdapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import thoughtworks.com.androidstarter.BuildConfig;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Config(constants = BuildConfig.class, sdk = 25)
@RunWith(RobolectricTestRunner.class)
public class CategoryViewTest {

    private CategoryViewModel categoryViewModel;
    private CategoryActivity activity;
    private CategoryView categoryView;
    private ArrayAdapter<Category> mockAdapter;

    @Before
    public void setUp() throws Exception {
        categoryViewModel = mock(CategoryViewModel.class);
        activity = Robolectric.buildActivity(CategoryActivity.class).get();
        when(categoryViewModel.getContext()).thenReturn(activity);

        mockAdapter = mock(ArrayAdapter.class);
        when(mockAdapter.getViewTypeCount()).thenReturn(1);
        when(categoryViewModel.buildArrayAdapter()).thenReturn(mockAdapter);

        categoryView = new CategoryView(categoryViewModel);
    }

    @Test
    public void shouldGetArrayAdapterFromCategoryViewModel() throws Exception {
        verify(categoryViewModel).buildArrayAdapter();
    }

    @Test
    public void shouldPopulateArrayAdapterUsingCategoryViewModel() throws Exception {
        verify(categoryViewModel).populateAdapter(mockAdapter);
    }

    @Test
    public void shouldSetViewsAdapterToBeArrayAdapterBuiltAndPopulatedByCategoryViewModel() throws Exception {
        ArrayAdapter<Category> actualAdapter = (ArrayAdapter<Category>) categoryView.getAdapter();

        assertThat(actualAdapter, is(equalTo(mockAdapter)));
    }

    @Test
    public void shouldGetOnItemClickListenerFromCategoryViewModel() throws Exception {
        verify(categoryViewModel).buildCategoryClickListener();
    }
}