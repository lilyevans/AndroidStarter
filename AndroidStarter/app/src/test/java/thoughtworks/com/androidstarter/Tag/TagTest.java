package thoughtworks.com.androidstarter.Tag;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TagTest {
    @Test
    public void shouldDisplayTagName() throws Exception {
        Tag tag = new Tag("Tag Name", "1", new ArrayList<String>());

        assertThat(tag.toString(), is(equalTo("Tag Name")));
    }
}