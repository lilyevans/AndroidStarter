package thoughtworks.com.androidstarter.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import thoughtworks.com.androidstarter.R;
import thoughtworks.com.androidstarter.models.Tag;
import thoughtworks.com.androidstarter.services.TagService;

public class TagsActivity extends AppCompatActivity {

    private TagService tagService;
    private ListView listView;
    private ArrayList<Tag> tags;

    private ArrayAdapter<Tag> arrayAdapter;
    private Intent intent;
    private AdapterView.OnItemClickListener onItemClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tags);

        tagService = new TagService();
        listView = (ListView) findViewById(R.id.tag_list_view);
        intent = getIntent();

        tags = tagService.getTagsByCategoryID(intent.getStringExtra("categoryID"));
        arrayAdapter = new ArrayAdapter<Tag>(this, R.layout.list_item, tags);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(onItemClickListener);
    }
}
