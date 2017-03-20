package thoughtworks.com.androidstarter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

@Config(constants = BuildConfig.class, sdk = 25)
@RunWith(RobolectricTestRunner.class)
public class CategoriesActivityTest {
    @Test
    public void shouldDisplayCategoriesWhenCreated() throws Exception {
        CategoriesActivity activity = Robolectric.setupActivity(CategoriesActivity.class);

    }
}