package thoughtworks.com.androidstarter.Tag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import thoughtworks.com.androidstarter.HttpModule;

public class TagActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        TagService tagService = new TagService(HttpModule.provideRetrofitInterface());
        TagViewModel tagViewModel = new TagViewModel(tagService, intent.getStringExtra("categoryID"));

        TagView tagView = new TagView(this, tagViewModel);
        setContentView(tagView);
    }
}
