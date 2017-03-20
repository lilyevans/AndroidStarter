package thoughtworks.com.androidstarter.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;

import thoughtworks.com.androidstarter.activities.TagsActivity;
import thoughtworks.com.androidstarter.models.Category;


public class OnCategoryItemClickListener extends AppCompatActivity implements AdapterView.OnItemClickListener {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Category category = (Category) parent.getItemAtPosition(position);
        Intent intent = new Intent(parent.getContext(), TagsActivity.class);
        intent.putExtra("categoryID", category.getID());

        startActivity(intent);
    }
}
