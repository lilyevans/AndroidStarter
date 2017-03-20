package thoughtworks.com.androidstarter.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;

import thoughtworks.com.androidstarter.models.Tag;


public class OnTagItemClickListener extends AppCompatActivity implements AdapterView.OnItemClickListener {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Tag tag = (Tag) parent.getItemAtPosition(position);
        Intent intent = new Intent(parent.getContext(), SongsActivity.class);
        intent.putStringArrayListExtra("songs", tag.getSongsWithTag());

        startActivity(intent);
    }
}
