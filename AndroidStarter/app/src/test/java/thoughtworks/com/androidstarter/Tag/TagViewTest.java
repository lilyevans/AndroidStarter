package thoughtworks.com.androidstarter.Tag;

import android.widget.ArrayAdapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import thoughtworks.com.androidstarter.BuildConfig;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Config(constants = BuildConfig.class, sdk = 25)
@RunWith(RobolectricTestRunner.class)
public class TagViewTest {

    private TagViewModel viewModel;
    private TagActivity tagActivity;
    private TagView tagView;
    private ArrayAdapter<Tag> mockAdapter;

    @Before
    public void setUp() throws Exception {
        viewModel = mock(TagViewModel.class);
        tagActivity = Robolectric.buildActivity(TagActivity.class).get();
        when(viewModel.getContext()).thenReturn(tagActivity);

        mockAdapter = mock(ArrayAdapter.class);
        when(mockAdapter.getViewTypeCount()).thenReturn(1);
        when(viewModel.buildArrayAdapter()).thenReturn(mockAdapter);

        tagView = new TagView(viewModel);
    }

    @Test
    public void shouldBuildArrayAdapterUsingTagViewModel() throws Exception {
        verify(viewModel).buildArrayAdapter();
    }

    @Test
    public void shouldPopulateArrayAdapterUsingTagViewModel() throws Exception {
        verify(viewModel).populateAdapter(mockAdapter);
    }

    @Test
    public void shouldSetViewsAdapterToBeAdapterPreparedByTagViewModel() throws Exception {
        ArrayAdapter<Tag> actualAdapter = (ArrayAdapter<Tag>) tagView.getAdapter();

        assertThat(actualAdapter, is(equalTo(mockAdapter)));
    }

    @Test
    public void shouldBuildOnItemClickListenerUsingTagViewModel() throws Exception {
        verify(viewModel).buildTagClickListener();
    }
}