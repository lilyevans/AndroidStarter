package thoughtworks.com.androidstarter.Category;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;

import thoughtworks.com.androidstarter.TagActivity;

public class OnCategoryClickListener extends AppCompatActivity implements AdapterView.OnItemClickListener {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Category category = (Category) parent.getItemAtPosition(position);

        Intent intent = new Intent(parent.getContext(), TagActivity.class);
        intent.putExtra("categoryID", category.getId());

        startActivity(intent);
    }
}
