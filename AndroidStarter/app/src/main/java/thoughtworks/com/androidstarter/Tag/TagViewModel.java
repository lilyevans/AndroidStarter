package thoughtworks.com.androidstarter.Tag;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import thoughtworks.com.androidstarter.R;

public class TagViewModel {
    private TagService tagService;

    public TagViewModel(TagService tagService) {
        this.tagService = tagService;
    }

    public ArrayAdapter<Tag> buildArrayAdapter(Context context) {
        ArrayAdapter<Tag> tagArrayAdapter = new ArrayAdapter<Tag>(context, R.layout.list_item_view, new ArrayList<Tag>());

        return tagArrayAdapter;
    }

    public void populateAdapter(String categoryId, ArrayAdapter<Tag> tagArrayAdapter) {
        tagArrayAdapter.setNotifyOnChange(true);
        tagService.getTags(categoryId, tagArrayAdapter);
    }

    public OnTagClickListener buildTagClickListener() {
        return new OnTagClickListener();
    }

}
