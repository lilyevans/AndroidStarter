package thoughtworks.com.androidstarter;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HttpService {

    public static RetrofitInterface buildRetrofitInterface() {
        Retrofit adapter = new Retrofit.Builder()
                .baseUrl("http://myurl.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return adapter.create(RetrofitInterface.class);
    }
}
