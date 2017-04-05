package thoughtworks.com.androidstarter.Category;

import android.widget.ArrayAdapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import thoughtworks.com.androidstarter.BuildConfig;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Config(constants = BuildConfig.class, sdk = 25)
@RunWith(RobolectricTestRunner.class)
public class CategoryViewTest {

    private CategoryViewModel categoryViewModel;
    private CategoryActivity activity;
    private CategoryView categoryView;

    @Before
    public void setUp() throws Exception {
        categoryViewModel = mock(CategoryViewModel.class);
        activity = Robolectric.buildActivity(CategoryActivity.class).get();
        when(categoryViewModel.getContext()).thenReturn(activity);

        categoryView = new CategoryView(categoryViewModel);
    }

    @Test
    public void shouldGetArrayAdapterFromCategoryViewModel() throws Exception {
        verify(categoryViewModel).buildArrayAdapter();
    }

    @Test
    public void shouldPopulateArrayAdapterUsingCategoryViewModel() throws Exception {
        verify(categoryViewModel).populateAdapter(any(ArrayAdapter.class));
    }

    @Test
    public void shouldGetOnItemClickListenerFromCategoryViewModel() throws Exception {
        verify(categoryViewModel).buildCategoryClickListener();
    }
}