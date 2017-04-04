package thoughtworks.com.androidstarter.Tag;

import android.widget.ArrayAdapter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import thoughtworks.com.androidstarter.BuildConfig;
import thoughtworks.com.androidstarter.RetrofitInterface;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Config(constants = BuildConfig.class, sdk = 25)
@RunWith(RobolectricTestRunner.class)
public class TagServiceTest {
    @Test
    public void shouldEnqueueCallFromRetrofitInterface() throws Exception {
        RetrofitInterface retrofitInterface = mock(RetrofitInterface.class);

        Call<List<Tag>> mockCall = mock(Call.class);
        when(retrofitInterface.getTags("1")).thenReturn(mockCall);
        TagService tagService = new TagService(retrofitInterface);

        tagService.getTags("1", any(ArrayAdapter.class));

        verify(mockCall).enqueue(any(Callback.class));

    }
}