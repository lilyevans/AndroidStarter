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
        ArrayAdapter<Tag> tagArrayAdapter = new ArrayAdapter<Tag>(context, R.layout.list_item_view, new ArrayList<Tag>());
        tagArrayAdapter.setNotifyOnChange(true);
        tagService.getTags(categoryId, tagArrayAdapter);

        return tagArrayAdapter;
    }

    public Context getContext() {
        return context;
    }

    public OnTagClickListener buildTagClickListener() {
        return new OnTagClickListener();
    }
}
