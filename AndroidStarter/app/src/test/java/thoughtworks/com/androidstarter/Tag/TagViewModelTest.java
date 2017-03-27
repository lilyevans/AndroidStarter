package thoughtworks.com.androidstarter.Tag;

import android.widget.ArrayAdapter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;

import thoughtworks.com.androidstarter.BuildConfig;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isA;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.anyString;
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
        when(tagService.getTags(anyString())).thenReturn(tags);
        TagActivity tagActivity = Robolectric.buildActivity(TagActivity.class).get();

        TagViewModel tagViewModel = new TagViewModel(tagActivity, tagService, "1");

        ArrayAdapter<Tag> actualAdapter = tagViewModel.buildArrayAdapter();

        assertThat(actualAdapter.getItem(0), is(equalTo(tag)));

    }

    @Test
    public void shouldBuildOnItemClickListenerForTags() throws Exception {
        TagService tagService = mock(TagService.class);
        TagActivity tagActivity = Robolectric.buildActivity(TagActivity.class).get();

        TagViewModel tagViewModel = new TagViewModel(tagActivity, tagService, "1");

        OnTagClickListener actualOnTagClickListener = tagViewModel.buildTagClickListener();

        assertNotNull(actualOnTagClickListener);
        assertThat(actualOnTagClickListener, isA(OnTagClickListener.class));

    }
}
