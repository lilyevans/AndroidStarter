package thoughtworks.com.androidstarter.models;

import org.junit.Test;

import java.util.ArrayList;

import thoughtworks.com.androidstarter.models.Tag;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TagTest {
    @Test
    public void shouldDisplayTagByTagName() throws Exception {
        String name = "Tag Name";
        Tag tag = new Tag(name, "1", new ArrayList<String>());

        assertThat(tag.toString(), is(equalTo(name)));
    }
}