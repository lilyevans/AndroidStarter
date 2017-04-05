package thoughtworks.com.androidstarter.Tag;

import android.widget.ArrayAdapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import thoughtworks.com.androidstarter.BuildConfig;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Config(constants = BuildConfig.class, sdk = 25)
@RunWith(RobolectricTestRunner.class)
public class TagViewTest {

    private TagViewModel viewModel;
    private TagActivity tagActivity;
    private TagView tagView;

    @Before
    public void setUp() throws Exception {
        viewModel = mock(TagViewModel.class);
        tagActivity = Robolectric.buildActivity(TagActivity.class).get();
        when(viewModel.getContext()).thenReturn(tagActivity);

        tagView = new TagView(viewModel);
    }

    @Test
    public void shouldBuildArrayAdapterUsingTagViewModel() throws Exception {
        verify(viewModel).buildArrayAdapter();
    }

    @Test
    public void shouldPopulateArrayAdapterUsingTagViewModel() throws Exception {
        verify(viewModel).populateAdapter(any(ArrayAdapter.class));
    }

    @Test
    public void shouldBuildOnItemClickListenerUsingTagViewModel() throws Exception {
        verify(viewModel).buildTagClickListener();
    }
}