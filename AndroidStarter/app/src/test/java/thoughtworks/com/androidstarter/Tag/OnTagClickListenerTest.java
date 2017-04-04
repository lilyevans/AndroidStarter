package thoughtworks.com.androidstarter.Tag;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import thoughtworks.com.androidstarter.BuildConfig;
import thoughtworks.com.androidstarter.Song.SongActivity;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.robolectric.Shadows.shadowOf;

@Config(constants = BuildConfig.class, sdk = 25)
@RunWith(RobolectricTestRunner.class)
public class OnTagClickListenerTest {
    @Test
    public void shouldStartNewSongActivityOnClick() throws Exception {
        TagActivity tagActivity = Robolectric.buildActivity(TagActivity.class).get();

        AdapterView adapterView = mock(AdapterView.class);
        when(adapterView.getContext()).thenReturn(tagActivity);
        when(adapterView.getItemAtPosition(anyInt())).thenReturn(mock(Tag.class));

        OnTagClickListener onTagClickListener = new OnTagClickListener();
        onTagClickListener.onItemClick(adapterView, mock(View.class), 0, (long) 0.0);

        Intent expectedIntent = new Intent(tagActivity, SongActivity.class);

        assertTrue(shadowOf(tagActivity).getNextStartedActivity().filterEquals(expectedIntent));
    }
}