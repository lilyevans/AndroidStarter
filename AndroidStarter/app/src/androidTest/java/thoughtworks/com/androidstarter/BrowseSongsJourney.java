package thoughtworks.com.androidstarter;

import android.support.test.espresso.base.IdlingResourceRegistry;
import android.support.test.espresso.base.IdlingResourceRegistry_Factory;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import thoughtworks.com.androidstarter.Category.Category;
import thoughtworks.com.androidstarter.Category.CategoryActivity;
import thoughtworks.com.androidstarter.Song.Song;
import thoughtworks.com.androidstarter.Tag.Tag;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.registerIdlingResources;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isIn;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class BrowseSongsJourney {
    @Rule
    public ActivityTestRule<CategoryActivity> activityActivityTestRule = new ActivityTestRule<CategoryActivity>(CategoryActivity.class);

    @Test
    public void browseSongs() throws Exception {
        registerIdlingResources(new CategoryViewIdlingResource(activityActivityTestRule.getActivity()));

        onData(withTitle(equalTo("Albums"))).check(matches(isDisplayed()));
        onData(withTitle(equalTo("Albums"))).perform(click());
        onData(withName(equalTo("Summertime 06"))).check(matches(isDisplayed()));
        onData(withName(equalTo("Summertime 06"))).perform(click());
        onData(withSongName(equalTo("Jump Off The Roof"))).check(matches(isDisplayed()));
    }

    private Matcher withTitle(final Matcher titleMatcher) {
        return new TypeSafeMatcher<Category>() {
            @Override
            protected boolean matchesSafely(Category category) {
                return titleMatcher.matches(category.toString());
            }

            @Override
            public void describeTo(Description description) {

            }
        };
    }

    private Matcher withName(final Matcher nameMatcher) {
        return new TypeSafeMatcher<Tag>() {
            @Override
            protected boolean matchesSafely(Tag tag) {
                return nameMatcher.matches(tag.toString());
            }

            @Override
            public void describeTo(Description description) {

            }
        };
    }

    private Matcher withSongName(final Matcher songTitleMatcher) {
        return new TypeSafeMatcher<Song>() {
            @Override
            protected boolean matchesSafely(Song song) {
                return songTitleMatcher.matches(song.toString());
            }

            @Override
            public void describeTo(Description description) {

            }
        };
    }
}
