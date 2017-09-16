package com.example.likho.change;

import android.icu.text.DecimalFormat;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;
import java.util.logging.Handler;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    double balance1;
    double balance2;
    double changeAmount;



    String text1;
    String text2;
    String text3;


    TextView bank1;
    TextView bank2;
    TextView change;



    Random rand = new Random();
    DecimalFormat ft = new DecimalFormat("#.##");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        balance1 = 5632;
        balance2 = 667.67;
        changeAmount = 5.57;

        text1 = "$"+balance1;
        text2 = "$"+balance2;
        text3 = "$"+changeAmount;

        bank1 = (TextView)findViewById(R.id.balance1);
        bank2 = (TextView)findViewById(R.id.balance2);
        change = (TextView) findViewById(R.id.changeText);

        bank1.setText(text1);
        bank2.setText(text2);
        change.setText(text3);
        int x;



        /*double temp1 = Math.floor(balance1);
        double changeTemp = balance1 - temp1;
        changeAmount += changeTemp;*/




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }




    public void action(View v){
        double floor1 = Math.floor(balance2); // finds the rounded number
        double cent = balance2 - floor1; // finds the remaining cents
        balance2 = floor1;
        changeAmount += cent;

        String formattedString = String.format(ft.format(changeAmount));
        String a = "$"+balance2;
        String b = "$"+formattedString;
        bank2.setText(a);
        change.setText(b);
    }


    public void pay(View v){
        double decimal = rand.nextDouble();
        int integer = rand.nextInt(50);
        double number = decimal+integer;

        balance2 -= number;
        text1 = "$"+ft.format(balance2);
        bank2.setText(text1);
    }





    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
