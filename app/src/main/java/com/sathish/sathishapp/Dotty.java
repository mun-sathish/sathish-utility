package com.sathish.sathishapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Dotty extends Activity {


    /* (non-Javadoc)
	 * @see android.app.Activity#onTouchEvent(android.view.MotionEvent)
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		tv.touchRec(event);
		return super.onTouchEvent(event);
	}

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
        					 WindowManager.LayoutParams.FLAG_FULLSCREEN);        
        
        		
        tv = new TestView(this);
        setContentView(tv);


        if (isFirstTime()) {

            AlertDialog.Builder alert = new AlertDialog.Builder(this);

            alert.setTitle("Multi Touch Tester");

            alert.setMessage("Try placing as many as your finger tips on the screen " +
                    "simultaneously and see how many touches does your phone takes.\n\n" +
                    "Generally it is 5 touches!!!");

            alert.setPositiveButton(R.string.ok, null);

            alert.show();
        }

    }
    TestView tv;
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




}