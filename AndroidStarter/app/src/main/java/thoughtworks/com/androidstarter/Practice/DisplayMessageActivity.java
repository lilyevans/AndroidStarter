package thoughtworks.com.androidstarter.Practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import thoughtworks.com.androidstarter.R;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra("com.thoughtworks.AndroidStarter.message");

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);

    }
}
