package thoughtworks.com.androidstarter.Tag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import thoughtworks.com.androidstarter.HttpService;
import thoughtworks.com.androidstarter.R;

public class TagActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        HttpService httpService = new HttpService();
        TagService tagService = new TagService(httpService);
        TagViewModel tagViewModel = new TagViewModel(this, tagService, intent.getStringExtra("categoryID"));

        TagView tagView = new TagView(tagViewModel);

        setContentView(tagView);
    }
}
