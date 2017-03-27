package thoughtworks.com.androidstarter.Tag;

import android.content.Context;
import android.widget.ListView;

import thoughtworks.com.androidstarter.R;

public class TagView extends ListView {
    public TagView(TagViewModel tagViewModel) {
        super(tagViewModel.getContext());
        setAdapter(tagViewModel.buildArrayAdapter());
        setOnItemClickListener(tagViewModel.buildTagClickListener());
        setId(R.id.tag_list_view);
    }
}
