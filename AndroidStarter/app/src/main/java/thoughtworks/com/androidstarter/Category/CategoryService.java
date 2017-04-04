package thoughtworks.com.androidstarter.Category;

import android.widget.ArrayAdapter;

import java.util.List;

import retrofit2.Call;
import thoughtworks.com.androidstarter.RetrofitInterface;


public class CategoryService {

    private RetrofitInterface retrofit;

    public CategoryService(RetrofitInterface retrofitInterface) {
        this.retrofit = retrofitInterface;
    }

    public void getCategories(ArrayAdapter<Category> categoryArrayAdapter) {
        Call<List<Category>> call = retrofit.getCategories();
        call.enqueue(new CategoryCallback(categoryArrayAdapter));

    }

}
