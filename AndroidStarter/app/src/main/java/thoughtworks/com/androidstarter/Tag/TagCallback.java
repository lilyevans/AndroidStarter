package thoughtworks.com.androidstarter.Tag;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import thoughtworks.com.androidstarter.R;

class TagCallback implements Callback<List<Tag>> {
    private ArrayList<Tag> tags;
    private ArrayAdapter<Tag> tagArrayAdapter;

    public TagCallback(ArrayAdapter<Tag> tagArrayAdapter) {
        this.tags = new ArrayList<Tag>();
        this.tagArrayAdapter = tagArrayAdapter;
    }

    @Override
    public void onResponse(Call<List<Tag>> call, Response<List<Tag>> response) {
        if(response.isSuccessful()){
            for (Tag tag : response.body()){
                tags.add(tag);
            }

            tagArrayAdapter.addAll(tags);
        }
    }

    @Override
    public void onFailure(Call<List<Tag>> call, Throwable t) {

    }
}
