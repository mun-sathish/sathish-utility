package com.sathish.sathishapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class WelcomeScreen extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);

        Thread t = new Thread() {

            public void run() {
                try {
                    Thread.sleep(2000);

                    Intent i = new Intent();
                    i.setClassName("com.sathish.sathishapp", "com.sathish.sathishapp.SecondScreen");
                    startActivity(i);
                    finish();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();

    }



}
