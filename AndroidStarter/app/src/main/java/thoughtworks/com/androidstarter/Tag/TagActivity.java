package thoughtworks.com.androidstarter.Tag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dagger.Module;
import dagger.Provides;
import thoughtworks.com.androidstarter.DaggerTagComponent;
import thoughtworks.com.androidstarter.HttpModule;
import thoughtworks.com.androidstarter.TagComponent;
import thoughtworks.com.androidstarter.TagModule;

@Module
public class TagActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TagComponent component = DaggerTagComponent.builder().tagModule(new TagModule()).build();
        TagViewModel tagViewModel = component.provideTagViewModel();

        TagView tagView = new TagView(this, tagViewModel);
        setContentView(tagView);
    }

    @Provides
    public String provideCategoryIdFromIntent(){
        Intent intent = getIntent();

        return intent.getStringExtra("categoryID");
    }
}
