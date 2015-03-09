package com.fileo.fileo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;


public class Result extends Activity {

    private ArrayList<String> files = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //Retrieve the intent variables from the search page
        Intent intent = getIntent();
        String string_datefrom = intent.getStringExtra(Search.EXTRA_DATEFROM);
        String string_dateto = intent.getStringExtra(Search.EXTRA_DATETO);
        String string_title = intent.getStringExtra(Search.EXTRA_TITLE);

        //Load all of the results
        File file1 = new File(Environment.getExternalStorageDirectory().toString()+"/Download");
        File file2[] = file1.listFiles();
        for (int i=0; i < file2.length; i++){

            //Check for a title match
            if( string_title != "" ) {
                String title = file2[i].getName();
                if (!title.contains(string_title)){
                    continue;
                }
            }

            files.add( file2[i].getAbsolutePath() );
        }

        //Display all of the entries in the list
        ListView list = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>( this, R.layout.layout_file, files);
        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.result, menu);
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
}
