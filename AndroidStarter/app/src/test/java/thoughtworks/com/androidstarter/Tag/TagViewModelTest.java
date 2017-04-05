package thoughtworks.com.androidstarter.Tag;

import android.widget.ArrayAdapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import thoughtworks.com.androidstarter.BuildConfig;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.isA;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@Config(constants = BuildConfig.class, sdk = 25)
@RunWith(RobolectricTestRunner.class)
public class TagViewModelTest {

    private TagService tagService;
    private TagActivity tagActivity;
    private TagViewModel tagViewModel;

    @Before
    public void setUp() throws Exception {
        tagService = mock(TagService.class);
        tagActivity = Robolectric.buildActivity(TagActivity.class).get();
        tagViewModel = new TagViewModel(tagActivity, tagService, "1");
    }

    @Test
    public void shouldBuildNewArrayAdapterWithTagsFromTagService() throws Exception {
        ArrayAdapter<Tag> actualAdapter = tagViewModel.buildArrayAdapter();

        assertThat(actualAdapter, is(instanceOf(ArrayAdapter.class)));
    }

    @Test
    public void shouldPrepareAndPopulateArrayAdapterUsingTagService() throws Exception {
        ArrayAdapter<Tag> adapter = mock(ArrayAdapter.class);

        tagViewModel.populateAdapter(adapter);

        verify(adapter).setNotifyOnChange(true);
        verify(tagService).getTags("1", adapter);
    }

    @Test
    public void shouldBuildOnItemClickListenerForTags() throws Exception {
        OnTagClickListener actualOnTagClickListener = tagViewModel.buildTagClickListener();

        assertNotNull(actualOnTagClickListener);
        assertThat(actualOnTagClickListener, isA(OnTagClickListener.class));

    }
}
