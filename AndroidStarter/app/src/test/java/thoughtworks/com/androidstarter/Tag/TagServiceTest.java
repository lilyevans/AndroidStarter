package thoughtworks.com.androidstarter.Tag;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;

import thoughtworks.com.androidstarter.BuildConfig;
import thoughtworks.com.androidstarter.HttpService;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.Is.isA;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Config(constants = BuildConfig.class, sdk = 25)
@RunWith(RobolectricTestRunner.class)
public class TagServiceTest {
    @Test
    public void shouldReturnEmptyTagListWhenJSONArrayIsEmpty() throws Exception {
        HttpService httpService = mock(HttpService.class);
        when(httpService.getTags(anyString())).thenReturn(new JSONArray("[]"));

        TagService tagService = new TagService(httpService);
        ArrayList<Tag> actualTags = tagService.getTags("1");

        assertThat(actualTags.size(), is(equalTo(0)));
    }

    @Test
    public void shouldReturnTagObjectsFromNonEmptyJSONArray() throws Exception {
        HttpService httpService = mock(HttpService.class);
        String jsonString = "[{'name':'Name', 'id':'1', 'song_ids':[1,2,3]}]";
        when(httpService.getTags(anyString())).thenReturn(new JSONArray(jsonString));

        TagService tagService = new TagService(httpService);
        ArrayList<Tag> actualTags = tagService.getTags("1");

        assertThat(actualTags.get(0), isA(Tag.class));
    }

    @Test
    public void shouldReturnNullFromInvalidJSON() throws Exception {
        HttpService httpService = mock(HttpService.class);
        TagService tagService = new TagService(httpService);

        Tag tag = tagService.parseTag(new JSONObject("{'title': 'Title'}"));
        assertNull(tag);

    }

    @Test
    public void shouldParseTagFromValidJSON() throws Exception {
        HttpService httpService = mock(HttpService.class);
        TagService tagService = new TagService(httpService);

        Tag tag = tagService.parseTag(new JSONObject("{'name':'Name', 'id':'1', 'song_ids':[1,2,3]}"));

        assertThat(tag.getName(), is(equalTo("Name")));
        assertThat(tag.getId(), is(equalTo("1")));
        assertThat(tag.getSongIds().get(0), is(equalTo("1")));

    }
}