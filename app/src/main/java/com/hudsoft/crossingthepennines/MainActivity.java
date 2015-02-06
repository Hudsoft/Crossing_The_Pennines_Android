package com.hudsoft.crossingthepennines;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.content.Intent;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends ActionBarActivity {

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            new Timer().schedule(new TimerTask(){
                public void run() {
                    startActivity(new Intent(MainActivity.this, MapsActivity.class));
                }
            }, 1000);
        }
}
