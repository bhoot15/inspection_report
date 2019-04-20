package com.xubi.inspectionreport;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;

import com.xubi.inspectionreport.dialog.DateDialog;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private TextView reportDateTv, inspectionDateTv;
    private Calendar newDate;
    private String reportDateString, inspectionDateString;
    private DateDialog dialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        initViews();
        setOnClickListener();
    }

    private void setOnClickListener() {
        reportDateTv.setOnClickListener(this);
        inspectionDateTv.setOnClickListener(this);
    }

    private void initViews() {
        reportDateTv = findViewById(R.id.report_date_tv);
        inspectionDateTv = findViewById(R.id.tv_inspection_date);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /*@Override
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
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.report_date_tv:
                dialogFragment = new DateDialog(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        newDate = Calendar.getInstance();
                        newDate.set(year, monthOfYear, dayOfMonth);

                        reportDateTv.setText("  " + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                        reportDateString = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;

                    }
                });
                dialogFragment.show(getSupportFragmentManager(), "Report Date");
                break;
            case R.id.tv_inspection_date:
                dialogFragment = new DateDialog(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        newDate = Calendar.getInstance();
                        newDate.set(year, monthOfYear, dayOfMonth);

                        inspectionDateTv.setText("  " + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                        inspectionDateString = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;

                    }
                });
                dialogFragment.show(getSupportFragmentManager(), "Inspection Date");
                break;
            default:
                break;
        }
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_yes:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radio_no:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }
}
