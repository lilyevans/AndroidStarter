package thoughtworks.com.androidstarter.Category;

import android.widget.ArrayAdapter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import retrofit2.Call;
import thoughtworks.com.androidstarter.BuildConfig;
import thoughtworks.com.androidstarter.RetrofitInterface;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Config(constants = BuildConfig.class, sdk = 25)
@RunWith(RobolectricTestRunner.class)
public class CategoryServiceTest {

    @Test
    public void shouldEnqueueCallFromRetrofitInterface() throws Exception {
        RetrofitInterface retrofitInterface = mock(RetrofitInterface.class);
        Call<List<Category>> mockCall = mock(Call.class);
        when(retrofitInterface.getCategories()).thenReturn(mockCall);

        CategoryService categoryService = new CategoryService(retrofitInterface);

        categoryService.getCategories(mock(ArrayAdapter.class));

        verify(mockCall).enqueue(any(CategoryCallback.class));

    }


}
