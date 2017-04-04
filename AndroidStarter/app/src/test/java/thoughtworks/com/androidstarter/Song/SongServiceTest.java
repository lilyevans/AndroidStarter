package thoughtworks.com.androidstarter.Song;

import android.widget.ArrayAdapter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import thoughtworks.com.androidstarter.BuildConfig;
import thoughtworks.com.androidstarter.RetrofitInterface;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Config(constants = BuildConfig.class, sdk = 25)
@RunWith(RobolectricTestRunner.class)
public class SongServiceTest {
    @Test
    public void shouldEnqueueCallFromRetrofitInterface() throws Exception {
        RetrofitInterface retrofitInterface = mock(RetrofitInterface.class);
        Call<List<Song>> mockCall = mock(Call.class);
        when(retrofitInterface.getSongs(Matchers.any(List.class))).thenReturn(mockCall);

        SongService songService = new SongService(retrofitInterface);

        songService.getSongs(new ArrayList<String>(), Matchers.any(ArrayAdapter.class));

        verify(mockCall).enqueue(Matchers.any(SongCallback.class));

    }


}