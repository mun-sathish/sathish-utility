package com.sathish.sathishapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Developer extends ActionBarActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
        setContentView(R.layout.developer);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);





        TextView event1 = (TextView) findViewById(R.id.listText);
        Typeface e1 = Typeface.createFromAsset(getAssets(),"Kavoon.otf");
        event1.setTypeface(e1);

        TextView event2 = (TextView) findViewById(R.id.detail_head);
        Typeface e2 = Typeface.createFromAsset(getAssets(),"Roboto-Black.ttf");
        event2.setTypeface(e2);

        TextView event3 = (TextView) findViewById(R.id.detail_content);
        Typeface e3 = Typeface.createFromAsset(getAssets(),"Roboto-Regular.ttf");
        event3.setTypeface(e3);

        TextView event4 = (TextView) findViewById(R.id.event2);
        Typeface e4 = Typeface.createFromAsset(getAssets(),"Roboto-Black.ttf");
        event4.setTypeface(e4);

        TextView event5 = (TextView) findViewById(R.id.event3);
        Typeface e5 = Typeface.createFromAsset(getAssets(),"Roboto-Regular.ttf");
        event5.setTypeface(e5);

        TextView event6 = (TextView) findViewById(R.id.event4);
        Typeface e6 = Typeface.createFromAsset(getAssets(),"Roboto-Regular.ttf");
        event6.setTypeface(e6);

        TextView event7 = (TextView) findViewById(R.id.event5);
        Typeface e7 = Typeface.createFromAsset(getAssets(),"Roboto-Regular.ttf");
        event7.setTypeface(e7);

        TextView event8 = (TextView) findViewById(R.id.event6);
        Typeface e8 = Typeface.createFromAsset(getAssets(),"Roboto-Regular.ttf");
        event8.setTypeface(e8);

        TextView event9 = (TextView) findViewById(R.id.event7);
        Typeface e9 = Typeface.createFromAsset(getAssets(),"Roboto-Regular.ttf");
        event9.setTypeface(e9);

        TextView event10= (TextView) findViewById(R.id.event8);
        Typeface e10= Typeface.createFromAsset(getAssets(),"Roboto-Regular.ttf");
        event10.setTypeface(e10);

        TextView event11 = (TextView) findViewById(R.id.event9);
        Typeface e11 = Typeface.createFromAsset(getAssets(),"Roboto-Regular.ttf");
        event11.setTypeface(e11);

        TextView event12 = (TextView) findViewById(R.id.event10);
        Typeface e12 = Typeface.createFromAsset(getAssets(),"Roboto-Regular.ttf");
        event12.setTypeface(e12);



    }



    public void fb (View view) {
        goToUrl ( "https://www.facebook.com/sathish.mun");
    }

    public void google (View view) {
        goToUrl ( "https://plus.google.com/u/0/+SathishMun/posts");
    }

    public void linkedin (View view) {
        goToUrl ( "https://www.linkedin.com/in/sathishmun");
    }

    public void appzoom (View view) {
        goToUrl ( "http://www.appszoom.com/android_developer/v-sathish-munna_pjcwm.html");
    }


    public void hackerearth (View view) {
        goToUrl ( "https://www.hackerearth.com/users/sathish.mun/");
    }

    public void instagram (View view) {
        goToUrl ( "https://instagram.com/sathishmun/");
    }

    public void twitter (View view) {
        goToUrl ( "https://twitter.com/mun_sathish");
    }


    public void youtube (View view) {
        goToUrl ( "https://www.youtube.com/channel/UCdHKTfk9ugtn2319tsFiCVw");
    }

    public void aboutme (View view) {
        goToUrl ( "https://about.me/mun.sathish");
    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_developer, menu);
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
