package com.fileo.fileo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Search extends Activity {

    //Extra variables that are passed to the result page
    public final static String EXTRA_DATEFROM = "com.fileo.fileo.DATEFROM";
    public final static String EXTRA_DATETO = "com.fileo.fileo.DATETO";
    public final static String EXTRA_TITLE = "com.fileo.fileo.TITLE";
    public final static String EXTRA_TYPE = "com.fileo.fileo.TYPE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Calls all of the search results
    public void openResult(View view) {

        //Create intent for the result page
        Intent intent = new Intent(this, Result.class);

        //Get the date from
        EditText edit_datefrom = (EditText) findViewById(R.id.edit_datefrom);
        String string_datefrom = edit_datefrom.getText().toString();
        intent.putExtra(EXTRA_DATEFROM, string_datefrom);

        //Get the date to
        EditText edit_dateto = (EditText) findViewById(R.id.edit_dateto);
        String string_dateto = edit_dateto.getText().toString();
        intent.putExtra(EXTRA_DATETO, string_dateto);

        //Get the title
        EditText edit_title = (EditText) findViewById(R.id.edit_title);
        String string_title = edit_title.getText().toString();
        intent.putExtra(EXTRA_TITLE, string_title);

        //Start the intent
        startActivity(intent);

    }

}
