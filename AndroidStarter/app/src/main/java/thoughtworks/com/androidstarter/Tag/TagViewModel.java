package thoughtworks.com.androidstarter.Tag;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import thoughtworks.com.androidstarter.R;

public class TagViewModel {
    private Context context;
    private TagService tagService;

    public TagViewModel(Context context, TagService tagService) {
        this.context = context;
        this.tagService = tagService;
    }

    public ArrayAdapter<Tag> buildArrayAdapter() {
        ArrayList<Tag> tags = tagService.getTags();
        return new ArrayAdapter<Tag>(context, R.layout.list_item_view, tags);
    }
}
