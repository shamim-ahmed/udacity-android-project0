package edu.udacity.android.project0;

import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Map<Integer, String> messageMap = getMessageMap();

        int[] buttonIds = {R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6};

        for (int id : buttonIds) {
            Button button = (Button) findViewById(id);
            String message = messageMap.get(id);
            button.setOnClickListener(new CustomOnClickListener(message));
        }
    }

    /**
     * Creates a map that contains the button keys as ids and toast messages as values
     */
    private Map<Integer, String> getMessageMap() {
        Resources resources = getResources();
        Map<Integer, String> messageMap = new HashMap<>();
        messageMap.put(R.id.button1, resources.getString(R.string.button1_click_text));
        messageMap.put(R.id.button2, resources.getString(R.string.button2_click_text));
        messageMap.put(R.id.button3, resources.getString(R.string.button3_click_text));
        messageMap.put(R.id.button4, resources.getString(R.string.button4_click_text));
        messageMap.put(R.id.button5, resources.getString(R.string.button5_click_text));
        messageMap.put(R.id.button6, resources.getString(R.string.button6_click_text));

        return messageMap;
    }

    /**
     * Custom OnClickListener that takes the toast message as an argument to constructor
     */
    private static class CustomOnClickListener implements View.OnClickListener {
        private final String message;

        public CustomOnClickListener(String message) {
            this.message = message;
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
