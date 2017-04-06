package thoughtworks.com.androidstarter.Tag;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.isA;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class TagViewModelTest {

    private TagService tagService;
    private TagViewModel tagViewModel;

    @Before
    public void setUp() throws Exception {
        tagService = mock(TagService.class);
        tagViewModel = new TagViewModel(tagService);
    }

    @Test
    public void shouldBuildNewArrayAdapterWithTagsFromTagService() throws Exception {
        Context mockContext = mock(Context.class);
        when(mockContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).thenReturn(mock(LayoutInflater.class));

        ArrayAdapter<Tag> actualAdapter = tagViewModel.buildArrayAdapter(mockContext);

        assertThat(actualAdapter, is(instanceOf(ArrayAdapter.class)));
    }

    @Test
    public void shouldPrepareAndPopulateArrayAdapterUsingTagService() throws Exception {
        String categoryId = "1";
        ArrayAdapter<Tag> adapter = mock(ArrayAdapter.class);

        tagViewModel.populateAdapter(categoryId, adapter);

        verify(adapter).setNotifyOnChange(true);
        verify(tagService).getTags(categoryId, adapter);
    }

    @Test
    public void shouldBuildOnItemClickListenerForTags() throws Exception {
        OnTagClickListener actualOnTagClickListener = tagViewModel.buildTagClickListener();

        assertNotNull(actualOnTagClickListener);
        assertThat(actualOnTagClickListener, isA(OnTagClickListener.class));
    }
}
