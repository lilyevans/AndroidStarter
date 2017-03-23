package thoughtworks.com.androidstarter.Tag;

import android.content.Context;
import android.widget.ListView;

public class TagView extends ListView {
    public TagView(TagViewModel tagViewModel) {
        super(tagViewModel.getContext());
        setAdapter(tagViewModel.buildArrayAdapter());
    }
}
