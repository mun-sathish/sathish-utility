package com.sathish.sathishapp;


import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;


public class SecondScreen extends ActionBarActivity implements View.OnClickListener {

    FloatingActionMenu actionMenu;
    private Toolbar toolbar;
    private ViewPager mPager;
    private static final String TAG_A = "a";

    private static final String TAG_C = "c";
    private static final String TAG_D = "d";

    private static final String TAG_H = "h";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_screen);


        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer,(DrawerLayout) findViewById(R.id.drawer_layout), toolbar);


        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));


        //Typeface e1 = Typeface.createFromAsset(getAssets(),"Kavoon.otf");
        //TextView event1 = (TextView) findViewById(R.id.event1);
        //event1.setTypeface(e1);


        ImageView icon = new ImageView(this); // Create an icon
        icon.setImageResource(R.drawable.ic_fab_star);

        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                .setContentView(icon)
                .setBackgroundDrawable(R.drawable.button_action_red_selector)
                .build();


        ImageView a = new ImageView(this);
        a.setImageResource(R.drawable.icon_paint);

        ImageView c = new ImageView(this);
        c.setImageResource(R.drawable.icon_diary);
        ImageView d = new ImageView(this);
        d.setImageResource(R.drawable.icon_hexaphone);


        ImageView h = new ImageView(this);
        h.setImageResource(R.drawable.icon_multitouch);


        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
        itemBuilder.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_action_blue_selector));

        SubActionButton buttona = itemBuilder.setContentView(a).build();

        SubActionButton buttonc = itemBuilder.setContentView(c).build();
        SubActionButton buttond = itemBuilder.setContentView(d).build();

        SubActionButton buttonh = itemBuilder.setContentView(h).build();

        buttona.setTag(TAG_A);

        buttonc.setTag(TAG_C);
        buttond.setTag(TAG_D);

        buttonh.setTag(TAG_H);

        buttona.setOnClickListener(this);

        buttonc.setOnClickListener(this);
        buttond.setOnClickListener(this);

        buttonh.setOnClickListener(this);

         actionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(buttona)

                .addSubActionView(buttonc)
                 .addSubActionView(buttond)

                 .addSubActionView(buttonh)
                .attachTo(actionButton)
                .build();


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        // TODO Auto-generated method stub
        super.onWindowFocusChanged(hasFocus);

        if(hasFocus)
        {
            Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                    .getBoolean("isFirstRun", true);

            if (isFirstRun) {
                //show start activity

                AlertDialog.Builder alert = new AlertDialog.Builder(this);

                alert.setTitle("SATHISH MESSAGE:");

                alert.setMessage("Dont Miss reading the ONE TIME MESSAGE that appear in each app if you " +
                        "want to know about it.\n\nHi guyz... \nThis is my First created Android App\n\n" +
                        "Do Check out all the apps... try to use those features and let me know the how the app feels to you.\n\n" +
                        "Each user who tried this app... I request you to give feedback to the following Email address mentioned below with short version of ur details.\n\n" +
                        "Plz try to Forward This APP to many as possible... \n\n  " +
                        "I hope u guyz will enjoy this app... Hav a Dumbling!!!\n\n" +
                        " (: (: (: (: THANK YOU :) :) :) :) " +
                        "\n\n\n\nV.SATHISH\n2nd Year, Dept of CSE\nSJBIT\nBANGALORE\nEmail - mun.sathish@gmail.com\nPh: 7353578127 ");

                alert.setPositiveButton(R.string.ok, null);

                alert.show();
            }


            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                    .putBoolean("isFirstRun", false).commit();
        }

    }


    private static final int TIME_INTERVAL = 1000; // # milliseconds, desired time passed between two back presses.
    private long mBackPressed;

    @Override
    public void onBackPressed()
    {
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis())
        {
            super.onBackPressed();

            return;
        }
        else { Toast.makeText(getBaseContext(), "Press Back again to Exit", Toast.LENGTH_SHORT).show(); }

        mBackPressed = System.currentTimeMillis();
    }

    @Override
    public void onClick(View v) {
       // android.support.v4.app.Fragment myFragment = null;
        if(v.getTag().equals(TAG_A))
        {
            actionMenu.close(true);
            Intent intent = new Intent(this, EasyPaint.class);
            startActivity(intent);

        }



        if(v.getTag().equals(TAG_C))
        {
            actionMenu.close(true);
            Intent intent = new Intent(this, Diary.class);
            startActivity(intent);
        }
        if(v.getTag().equals(TAG_D))
        {
            actionMenu.close(true);
            Intent intent = new Intent(this, Play.class);
            startActivity(intent);
        }

        if(v.getTag().equals(TAG_H))
        {
            actionMenu.close(true);
            Intent intent = new Intent(this, Dotty.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if(id == R.id.navigate)
        {
            Intent intent = new Intent(this, Developer.class);
            startActivity(intent);
            overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
           //  Toast.makeText(getApplicationContext(),"You can create a common activity " +
             //       "for this button",Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }



    class MyPagerAdapter extends FragmentPagerAdapter  //for tabs
    {
        String[] tabs;
        public MyPagerAdapter(android.support.v4.app.FragmentManager fm) { //fragmentchange
            super(fm);
            tabs = getResources().getStringArray(R.array.tabs);
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {//fragmentchange
            //  MyFragment myFragment = MyFragment.getInstance(position);

            android.support.v4.app.Fragment myFragment = null;
            if(position == 0)
            {
                myFragment = new FragmentA();
            }
            if(position == 1)
            {
                myFragment = new FragmentB();
            }
            if(position == 2)
            {
                myFragment = new FragmentC();
            }
            if(position == 3)
            {
                myFragment = new FragmentD();
            }
            if(position == 4)
            {
                myFragment = new FragmentE();
            }
            if(position == 5)
            {
                myFragment = new FragmentF();
            }
            if(position == 6)
            {
                myFragment = new FragmentG();
            }
            if(position == 7)
            {
                myFragment = new FragmentH();
            }

            return myFragment;
        }

        @Override
        public int getCount() {
            return 8;
        }
    }

    public static class FragmentA extends android.support.v4.app.Fragment  //JAVA CLASS FOR FRAGMENT 1 //fragmentchange
    {


        @Override
        public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
            View layout = inflater.inflate(R.layout.fragmenta, container,false);
           Button event1 = (Button) layout.findViewById(R.id.button);
            Typeface e1 = Typeface.createFromAsset(getActivity().getAssets(),"Kavoon.otf");
            event1.setTypeface(e1);
            return layout;
        }
    }






    public static class FragmentB extends android.support.v4.app.Fragment  //JAVA CLASS FOR FRAGMENT 2
    {


        @Override
        public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
            View layout = inflater.inflate(R.layout.fragmentb, container,false);

            Button event1 = (Button) layout.findViewById(R.id.button);
            Typeface e1 = Typeface.createFromAsset(getActivity().getAssets(),"Kavoon.otf");
            event1.setTypeface(e1);

            return layout;
        }


    }







    public static class FragmentC extends android.support.v4.app.Fragment  //JAVA CLASS FOR FRAGMENT 3
    {
        @Override
        public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
            View layout = inflater.inflate(R.layout.fragmentc, container,false);
            Button event1 = (Button) layout.findViewById(R.id.button);
            Typeface e1 = Typeface.createFromAsset(getActivity().getAssets(),"Kavoon.otf");
            event1.setTypeface(e1);
            return layout;
        }
    }


    public static class FragmentD extends android.support.v4.app.Fragment  //JAVA CLASS FOR FRAGMENT 3
    {
        @Override
        public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
            View layout = inflater.inflate(R.layout.fragmentd_hexaphone, container,false);
            Button event1 = (Button) layout.findViewById(R.id.button);
            Typeface e1 = Typeface.createFromAsset(getActivity().getAssets(),"Kavoon.otf");
            event1.setTypeface(e1);
            return layout;
        }
    }


    public static class FragmentE extends android.support.v4.app.Fragment  //JAVA CLASS FOR FRAGMENT 3
    {
        @Override
        public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
            View layout = inflater.inflate(R.layout.fragmente_typeandlisten, container,false);
            Button event1 = (Button) layout.findViewById(R.id.button);
            Typeface e1 = Typeface.createFromAsset(getActivity().getAssets(),"Kavoon.otf");
            event1.setTypeface(e1);
            return layout;
        }
    }


    public static class FragmentF extends android.support.v4.app.Fragment  //JAVA CLASS FOR FRAGMENT 3
    {
        @Override
        public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
            View layout = inflater.inflate(R.layout.fragmentf_oscilloscope, container,false);
            Button event1 = (Button) layout.findViewById(R.id.button);
            Typeface e1 = Typeface.createFromAsset(getActivity().getAssets(),"Kavoon.otf");
            event1.setTypeface(e1);
            return layout;
        }
    }

    public static class FragmentG extends android.support.v4.app.Fragment  //JAVA CLASS FOR FRAGMENT 3
    {
        @Override
        public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
            View layout = inflater.inflate(R.layout.fragmentg_colorclock, container,false);
            Button event1 = (Button) layout.findViewById(R.id.button);
            Typeface e1 = Typeface.createFromAsset(getActivity().getAssets(),"Kavoon.otf");
            event1.setTypeface(e1);
            return layout;
        }
    }

    public static class FragmentH extends android.support.v4.app.Fragment  //JAVA CLASS FOR FRAGMENT 3
    {
        @Override
        public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
            View layout = inflater.inflate(R.layout.fragmenth_multitouch, container,false);
            Button event1 = (Button) layout.findViewById(R.id.button);
            Typeface e1 = Typeface.createFromAsset(getActivity().getAssets(),"Kavoon.otf");
            event1.setTypeface(e1);
            return layout;
        }
    }

public void paint(View v)
{
    Thread t = new Thread() {

        public void run() {
            try {
                Thread.sleep(450);

                Intent intent = new Intent(getApplicationContext(), EasyPaint.class);
                startActivity(intent);
                //  overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
               // overridePendingTransition(R.anim.abc_fade_in,R.anim.abc_fade_out);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    t.start();

}

    public void email(View v)
    {
        Thread t = new Thread() {

            public void run() {
                try {
                    Thread.sleep(450);

                    Intent intent = new Intent(getApplicationContext(), Email.class);
                    startActivity(intent);
                    //  overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
                    // overridePendingTransition(R.anim.abc_fade_in,R.anim.abc_fade_out);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }

    public void diary(View v)
    {
        Thread t = new Thread() {

            public void run() {
                try {
                    Thread.sleep(450);

                    Intent intent = new Intent(getApplicationContext(), Diary.class);
                    startActivity(intent);
                    //  overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
                    // overridePendingTransition(R.anim.abc_fade_in,R.anim.abc_fade_out);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }


    public void hexaphone(View v)
    {
        Thread t = new Thread() {

            public void run() {
                try {
                    Thread.sleep(450);

                    Intent intent = new Intent(getApplicationContext(), Play.class);
                    startActivity(intent);
                    //  overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
                    // overridePendingTransition(R.anim.abc_fade_in,R.anim.abc_fade_out);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }


    public void type(View v)
    {
        Thread t = new Thread() {

            public void run() {
                try {
                    Thread.sleep(450);

                    Intent intent = new Intent(getApplicationContext(), TypeAndSpeak.class);
                    startActivity(intent);
                    //  overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
                    // overridePendingTransition(R.anim.abc_fade_in,R.anim.abc_fade_out);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }


    public void oscilloscope(View v)
    {
        Thread t = new Thread() {

            public void run() {
                try {
                    Thread.sleep(450);

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    //  overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
                    // overridePendingTransition(R.anim.abc_fade_in,R.anim.abc_fade_out);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }



    public void clock(View v)
    {
        Thread t = new Thread() {

            public void run() {
                try {
                    Thread.sleep(450);

                    Intent intent = new Intent(getApplicationContext(), ClockActivity.class);
                    startActivity(intent);
                    //  overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
                    // overridePendingTransition(R.anim.abc_fade_in,R.anim.abc_fade_out);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }



    public void multitouch(View v)
    {
        Thread t = new Thread() {

            public void run() {
                try {
                    Thread.sleep(450);

                    Intent intent = new Intent(getApplicationContext(), Dotty.class);
                    startActivity(intent);
                    //  overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
                    // overridePendingTransition(R.anim.abc_fade_in,R.anim.abc_fade_out);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }




/*
    public void varchasva(View v)
    {Thread t = new Thread() {

        public void run() {
            try {
                Thread.sleep(450);

                Intent intent = new Intent(getApplicationContext(), V_Main.class);
                startActivity(intent);
                //  overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
                overridePendingTransition(R.anim.abc_fade_in,R.anim.abc_fade_out);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
        t.start();

    }

*/




}
