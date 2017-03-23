package thoughtworks.com.androidstarter.Tag;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import thoughtworks.com.androidstarter.R;

public class TagViewModel {
    private String categoryId;
    private Context context;
    private TagService tagService;

    public TagViewModel(Context context, TagService tagService, String categoryId) {
        this.context = context;
        this.tagService = tagService;
        this.categoryId = categoryId;
    }

    public ArrayAdapter<Tag> buildArrayAdapter() {
        ArrayList<Tag> tags = tagService.getTags(categoryId);
        return new ArrayAdapter<Tag>(context, R.layout.list_item_view, tags);
    }

    public Context getContext() {
        return context;
    }
}
