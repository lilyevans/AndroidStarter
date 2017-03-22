package thoughtworks.com.androidstarter.Category;

import android.widget.ListView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import thoughtworks.com.androidstarter.BuildConfig;
import thoughtworks.com.androidstarter.Category.CategoryActivity;
import thoughtworks.com.androidstarter.R;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@Config(constants = BuildConfig.class, sdk = 25)
@RunWith(RobolectricTestRunner.class)
public class CategoryActivityTest {
    @Test
    public void shouldBuildThreeTextViewsOnCreationWhenServiceProvidesThreeCategories() throws Exception {
//        CategoryActivity categoryActivity = Robolectric.buildActivity(CategoryActivity.class).create().get();
//        categoryActivity.
//
//        assertThat(listView.getAdapter().getCount(), is(equalTo(3)));

    }

}
