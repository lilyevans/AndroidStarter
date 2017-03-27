package thoughtworks.com.androidstarter.Tag;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import thoughtworks.com.androidstarter.Song.SongActivity;

class OnTagClickListener implements AdapterView.OnItemClickListener{
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Tag tag = (Tag) parent.getItemAtPosition(position);
        Intent intent = new Intent(parent.getContext(), SongActivity.class);
        intent.putStringArrayListExtra("songIDs", tag.getSongIds());

        parent.getContext().startActivity(intent);
    }
}
