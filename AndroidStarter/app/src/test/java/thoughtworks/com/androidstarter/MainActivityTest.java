package thoughtworks.com.androidstarter;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertThat;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by lilyevans on 3/14/17.
 */

@Config(constants = BuildConfig.class, sdk = 25)
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    @Test
    public void shouldDisplayTextBoxOnCreation() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        EditText textBox = (EditText) activity.findViewById(R.id.editText);

        assert(textBox.getHint().toString().equals("Enter a message"));

    }

    @Test
    public void shouldDisplayButtonOnCreation() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        Button button = (Button) activity.findViewById(R.id.button);

        assert(button.getText().toString().equals("Send"));
    }

    @Test
    public void shouldUpdateWhenButtonClicked() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        Button button = (Button) activity.findViewById(R.id.button);

        activity.sendMessage(button);

        Intent expectedIntent = new Intent(activity, DisplayMessageActivity.class);

        assert(shadowOf(activity).getNextStartedActivity()).equals(expectedIntent);
    }
}