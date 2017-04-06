package thoughtworks.com.androidstarter.Tag;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import thoughtworks.com.androidstarter.DaggerTagComponent;
import thoughtworks.com.androidstarter.TagComponent;
import thoughtworks.com.androidstarter.TagModule;

public class TagActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TagComponent component = DaggerTagComponent.builder().tagModule(new TagModule()).build();
        TagViewModel tagViewModel = component.provideTagViewModel();
        TagView tagView = new TagView(this, getCategoryId(), tagViewModel);

        setContentView(tagView);
    }

    private String getCategoryId(){
        Intent intent = getIntent();
        String categoryId = "";

        if (intent.hasExtra("categoryID")){
            categoryId = intent.getStringExtra("categoryID");
        }

        return categoryId;
    }
}
