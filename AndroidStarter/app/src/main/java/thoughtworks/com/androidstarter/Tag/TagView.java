package thoughtworks.com.androidstarter.Tag;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import javax.inject.Inject;

import thoughtworks.com.androidstarter.R;

public class TagView extends ListView {
    @Inject
    public TagView(Context context, TagViewModel tagViewModel) {
        super(context);

        ArrayAdapter<Tag> tagAdapter = tagViewModel.buildArrayAdapter(context);
        tagViewModel.populateAdapter(tagAdapter);
        setAdapter(tagAdapter);

        setOnItemClickListener(tagViewModel.buildTagClickListener());
        setId(R.id.tag_list_view);
    }
}
