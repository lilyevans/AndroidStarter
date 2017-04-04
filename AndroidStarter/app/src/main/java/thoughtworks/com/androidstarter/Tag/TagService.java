package thoughtworks.com.androidstarter.Tag;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import thoughtworks.com.androidstarter.RetrofitInterface;

public class TagService {

    private RetrofitInterface retrofitInterface;

    public TagService(RetrofitInterface retrofitInterface){
        this.retrofitInterface = retrofitInterface;
    }

    public void getTags(String categoryId, ArrayAdapter<Tag> tagArrayAdapter) {
        ArrayList<Tag> tags = new ArrayList<Tag>();

        Call<List<Tag>> call = retrofitInterface.getTags(categoryId);
        call.enqueue(new TagCallback(tagArrayAdapter));
    }

}
