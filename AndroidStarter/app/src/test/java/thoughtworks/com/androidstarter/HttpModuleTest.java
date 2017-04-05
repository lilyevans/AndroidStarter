package thoughtworks.com.androidstarter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;

@Config(constants = BuildConfig.class, sdk = 25)
@RunWith(RobolectricTestRunner.class)
public class HttpModuleTest {
    @Test
    public void shouldBuildRetrofitInterfaceInstance() throws Exception {
        RetrofitInterface actualRetrofit = HttpModule.provideRetrofitInterface();

        assertThat(actualRetrofit, is(notNullValue(RetrofitInterface.class)));

    }
}
