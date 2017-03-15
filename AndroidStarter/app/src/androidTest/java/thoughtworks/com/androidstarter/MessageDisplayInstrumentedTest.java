package thoughtworks.com.androidstarter;

import android.support.test.espresso.action.ViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by lilyevans on 3/15/17.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MessageDisplayInstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);
    @Test
    public void shouldDisplayMessageUserSubmits() throws Exception {
        onView(withId(R.id.editText)).perform(typeText("Hello World!"));
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.textView)).check(matches(withText("Hello World!")));

    }
}
