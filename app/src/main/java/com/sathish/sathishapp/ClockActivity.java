package com.sathish.sathishapp;
import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
public class ClockActivity extends Activity {
ColourClock mClock;

public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
mClock = new ColourClock(this);
setContentView(mClock);


    if (isFirstTime()) {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Color Clock");

        alert.setMessage("For every second, minute and hour there appears some separate " +
                "color. Try analysing and can use color names to notify time secretly/efficiently to your colleagues, " +
                "friends or relatives");

        alert.setPositiveButton(R.string.ok, null);

        alert.show();
    }

}
    private boolean isFirstTime() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        boolean ranBefore = preferences.getBoolean("RanBefore", false);
        if (!ranBefore) {
            // first time
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("RanBefore", true);
            editor.commit();
        }
        return !ranBefore;
    }




    @Override
protected void onResume() {
super.onResume();
Log.d("org.gringene.colourclock", "Resuming...");
mClock.startTick();
}
@Override
protected void onPause() {
super.onPause();
Log.d("org.gringene.colourclock", "Pausing...");
mClock.stopTick();
}
}