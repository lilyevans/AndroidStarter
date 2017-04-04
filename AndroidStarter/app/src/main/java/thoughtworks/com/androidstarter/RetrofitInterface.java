package thoughtworks.com.androidstarter;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import thoughtworks.com.androidstarter.Category.Category;
import thoughtworks.com.androidstarter.Song.Song;
import thoughtworks.com.androidstarter.Tag.Tag;

public interface RetrofitInterface {
    @GET("/api/1/tags/")
    Call<List<Category>> getCategories();

    @GET("/api/1/category/tag/{tag_id}")
    Call<List<Tag>> getTags(@Path("tag_id") String id);

    @GET("/api/1/songs/multi")
    Call<List<Song>> getSongs(@Query("id") List<String> songIds);
}
