package thoughtworks.com.androidstarter;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import thoughtworks.com.androidstarter.Category.Category;
import thoughtworks.com.androidstarter.Category.CategoryActivity;
import thoughtworks.com.androidstarter.Category.CategoryView;
import thoughtworks.com.androidstarter.Tag.Tag;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.core.deps.guava.base.Predicates.instanceOf;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.hamcrest.Matchers.isIn;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class BrowseSongsJourney {
    @Rule
    public ActivityTestRule<CategoryActivity> activityActivityTestRule = new ActivityTestRule<CategoryActivity>(CategoryActivity.class);

    @Test
    public void browseSongs() throws Exception {
        onData(withTitle(equalTo("Albums"))).check(matches(isDisplayed()));
        onData(withTitle(equalTo("Albums"))).perform(click());
        onData(withName(equalTo("Summertime 06"))).check(matches(isDisplayed()));
    }

    public Matcher withTitle(final Matcher titleMatcher) {
        return new TypeSafeMatcher<Category>() {
            @Override
            protected boolean matchesSafely(Category category) {
                return titleMatcher.matches(category.getTitle());
            }

            @Override
            public void describeTo(Description description) {

            }
        };
    }

    public Matcher withName(final Matcher nameMatcher) {
        return new TypeSafeMatcher<Tag>() {
            @Override
            protected boolean matchesSafely(Tag tag) {
                return nameMatcher.matches(tag.getName());
            }

            @Override
            public void describeTo(Description description) {

            }
        };
    }
}
