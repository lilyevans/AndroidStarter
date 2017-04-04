package thoughtworks.com.androidstarter;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;

@Config(constants = BuildConfig.class, sdk = 25)
@RunWith(RobolectricTestRunner.class)
public class HttpServiceTest {
    @Test
    public void shouldBuildRetrofitInterfaceInstance() throws Exception {
        RetrofitInterface actualRetrofit = HttpService.buildRetrofitInterface();

        assertThat(actualRetrofit, is(notNullValue(RetrofitInterface.class)));

    }
}
