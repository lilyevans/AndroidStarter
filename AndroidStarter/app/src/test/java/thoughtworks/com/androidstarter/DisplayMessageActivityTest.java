package thoughtworks.com.androidstarter;

import android.content.Intent;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.isNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by lilyevans on 3/15/17.
 */

@Config(constants = BuildConfig.class, sdk = 25)
@RunWith(RobolectricTestRunner.class)
public class DisplayMessageActivityTest {
    @Test
    public void shouldDisplayMessageFromPreviousActivityWhenCreated() throws Exception {
        Intent intent = new Intent();
        intent.putExtra(Extras.EXTRA_MESSAGE, "message");
        DisplayMessageActivity activity = Robolectric.buildActivity(DisplayMessageActivity.class, intent).setup().get();

        TextView textView = (TextView) activity.findViewById(R.id.textView);

        assertThat(textView.getText().toString(), is(equalTo("message")));

    }
}
