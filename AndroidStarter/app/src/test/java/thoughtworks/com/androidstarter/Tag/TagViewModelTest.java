package thoughtworks.com.androidstarter.Tag;

import android.widget.ArrayAdapter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;

import thoughtworks.com.androidstarter.BuildConfig;
import thoughtworks.com.androidstarter.Tag.Tag;
import thoughtworks.com.androidstarter.Tag.TagActivity;
import thoughtworks.com.androidstarter.Tag.TagService;
import thoughtworks.com.androidstarter.Tag.TagViewModel;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Config(constants = BuildConfig.class, sdk = 25)
@RunWith(RobolectricTestRunner.class)
public class TagViewModelTest {
    @Test
    public void shouldBuildArrayAdapterWithTagsFromTagService() throws Exception {
        ArrayList<Tag> tags = new ArrayList<Tag>();
        Tag tag = mock(Tag.class);
        tags.add(tag);

        TagService tagService = mock(TagService.class);
        when(tagService.getTags()).thenReturn(tags);
        TagActivity tagActivity = Robolectric.buildActivity(TagActivity.class).get();

        TagViewModel tagViewModel = new TagViewModel(tagActivity, tagService);

        ArrayAdapter<Tag> actualAdapter = tagViewModel.buildArrayAdapter();

        assertThat(actualAdapter.getItem(0), is(equalTo(tag)));

    }
}
