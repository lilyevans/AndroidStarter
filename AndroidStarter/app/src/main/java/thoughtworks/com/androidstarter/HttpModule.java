package thoughtworks.com.androidstarter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class HttpModule {

    @Provides @Singleton
    public static RetrofitInterface provideRetrofitInterface() {
        Retrofit adapter = new Retrofit.Builder()
                .baseUrl("http://myurl.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return adapter.create(RetrofitInterface.class);
    }
}
