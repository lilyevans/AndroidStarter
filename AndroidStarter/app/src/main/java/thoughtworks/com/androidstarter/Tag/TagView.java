package thoughtworks.com.androidstarter.Tag;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import thoughtworks.com.androidstarter.R;

public class TagView extends ListView {
    public TagView(TagViewModel tagViewModel) {
        super(tagViewModel.getContext());

        ArrayAdapter<Tag> tagAdapter = tagViewModel.buildArrayAdapter();
        tagViewModel.populateAdapter(tagAdapter);
        setAdapter(tagAdapter);

        setOnItemClickListener(tagViewModel.buildTagClickListener());
        setId(R.id.tag_list_view);
    }
}
