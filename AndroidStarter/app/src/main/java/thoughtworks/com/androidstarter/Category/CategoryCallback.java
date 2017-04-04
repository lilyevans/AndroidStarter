package thoughtworks.com.androidstarter.Category;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryCallback implements Callback<List<Category>> {
    private ArrayAdapter<Category> categoryArrayAdapter;
    private ArrayList<Category> categories;


    public CategoryCallback(ArrayAdapter<Category> categoryArrayAdapter){
        this.categoryArrayAdapter = categoryArrayAdapter;
        this.categories = new ArrayList<Category>();
    }

    @Override
    public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
        if (response.isSuccessful()){
            for (Category category : response.body()){
                categories.add(category);
            }

            categoryArrayAdapter.addAll(categories);
            System.out.println(categories);
        }
        else {
            System.out.println(response.errorBody());
        }

    }

    @Override
    public void onFailure(Call<List<Category>> call, Throwable t) {
        System.out.println(t);
    }
}
