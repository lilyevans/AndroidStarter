package thoughtworks.com.androidstarter.Category;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import thoughtworks.com.androidstarter.BuildConfig;
import thoughtworks.com.androidstarter.Tag.TagActivity;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.robolectric.Shadows.shadowOf;

@Config(constants = BuildConfig.class, sdk = 25)
@RunWith(RobolectricTestRunner.class)
public class OnCategoryClickListenerTest {
    @Test
    public void shouldStartNewTagActivityWhenClicked() throws Exception {
        CategoryActivity categoryActivity = Robolectric.buildActivity(CategoryActivity.class).get();

        AdapterView adapterView = mock(AdapterView.class);
        when(adapterView.getContext()).thenReturn(categoryActivity);
        when(adapterView.getItemAtPosition(anyInt())).thenReturn(mock(Category.class));

        OnCategoryClickListener onCategoryClickListener = new OnCategoryClickListener();
        onCategoryClickListener.onItemClick(adapterView, mock(View.class), 0, (long) 0.0);

        Intent expectedIntent = new Intent(categoryActivity, TagActivity.class);

        assertTrue(shadowOf(categoryActivity).getNextStartedActivity().filterEquals(expectedIntent));
    }
}