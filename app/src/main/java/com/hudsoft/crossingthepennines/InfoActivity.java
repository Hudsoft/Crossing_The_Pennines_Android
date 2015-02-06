package com.hudsoft.crossingthepennines;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class InfoActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        String location;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            //Accessed from MapsActivity by pressing an InfoWindow
            location = extras.getString("location");
        }else{
            //Accessed from AboutActivity through Back Stack
            location = "";
            Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
            startActivity(intent);
        }

        getSupportActionBar().setTitle(location);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_info, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_about:
                openAbout();
                break;
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }

    public void openAbout() {
        Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(intent);
    }
}
