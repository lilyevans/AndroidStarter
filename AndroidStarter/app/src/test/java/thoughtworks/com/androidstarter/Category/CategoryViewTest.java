package thoughtworks.com.androidstarter.Category;

import android.widget.ArrayAdapter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import thoughtworks.com.androidstarter.BuildConfig;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Config(constants = BuildConfig.class, sdk = 25)
@RunWith(RobolectricTestRunner.class)
public class CategoryViewTest {

    @Test
    public void shouldGetArrayAdapterFromCategoryViewModel() throws Exception {
        CategoryViewModel categoryViewModel = mock(CategoryViewModel.class);
        CategoryActivity activity = Robolectric.buildActivity(CategoryActivity.class).get();
        when(categoryViewModel.getContext()).thenReturn(activity);

        CategoryView categoryView = new CategoryView(categoryViewModel);

        verify(categoryViewModel).buildArrayAdapter();
    }

    @Test
    public void shouldPopulateArrayAdapterUsingCategoryViewModel() throws Exception {
        CategoryViewModel categoryViewModel = mock(CategoryViewModel.class);
        CategoryActivity activity = Robolectric.buildActivity(CategoryActivity.class).get();
        when(categoryViewModel.getContext()).thenReturn(activity);

        CategoryView categoryView = new CategoryView(categoryViewModel);

        verify(categoryViewModel).populateAdapter(any(ArrayAdapter.class));
    }

    @Test
    public void shouldGetOnItemClickListenerFromCategoryViewModel() throws Exception {
        CategoryViewModel categoryViewModel = mock(CategoryViewModel.class);
        CategoryActivity activity = Robolectric.buildActivity(CategoryActivity.class).get();
        when(categoryViewModel.getContext()).thenReturn(activity);

        CategoryView categoryView = new CategoryView(categoryViewModel);

        verify(categoryViewModel).buildCategoryClickListener();

    }
}