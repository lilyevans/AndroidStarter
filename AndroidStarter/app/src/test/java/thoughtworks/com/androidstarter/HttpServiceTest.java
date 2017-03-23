package thoughtworks.com.androidstarter;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

@Config(constants = BuildConfig.class, sdk = 25)
@RunWith(RobolectricTestRunner.class)
public class HttpServiceTest {
    @Test
    public void shouldReturnCategoryJSONArray() throws Exception {
        HttpService httpService = new HttpService();

        JSONArray jsonCategories = httpService.getCategories();
        JSONObject expectedJson0 = new JSONObject("{'title':'Genres','id':'1'}");
        JSONObject expectedJson1 = new JSONObject("{'title' : 'Artists', 'id': '2'}");
        JSONObject expectedJson2 = new JSONObject("{'title' : 'Albums', 'id': '3'}");

        assertThat(jsonCategories.getJSONObject(0).toString(), is(equalTo(expectedJson0.toString())));
        assertThat(jsonCategories.getJSONObject(1).toString(), is(equalTo(expectedJson1.toString())));
        assertThat(jsonCategories.getJSONObject(2).toString(), is(equalTo(expectedJson2.toString())));
        assertThat(jsonCategories.length(), is(equalTo(3)));
    }

    @Test
    public void shouldReturnTagJSONArray() throws Exception {
        HttpService httpService = new HttpService();

        JSONArray jsonTags = httpService.getTags("1");
        JSONObject expectedJSON0 = new JSONObject("{'name':'Hell Can Wait', 'id':'1', 'song_ids':[1]}");
        JSONObject expectedJSON1 = new JSONObject("{'name':'Summertime 06', 'id':'2', 'song_ids':[2,3]}");
        JSONObject expectedJSON2 = new JSONObject("{'name':'Prima Donna', 'id':'3', 'song_ids':[4,5]}");

        assertThat(jsonTags.getJSONObject(0).toString(), is(equalTo(expectedJSON0.toString())));

    }
}
