package com.xubi.inspectionreport.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.xubi.inspectionreport.R;
import com.xubi.inspectionreport.fragments.InspectionConclusionFragment;
import com.xubi.inspectionreport.fragments.MainContainerFragment;
import com.xubi.inspectionreport.fragments.QuantityFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentTransaction fragmentTransaction;

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

        if (savedInstanceState == null) {
            // Instance of first fragment
            goToMainContainerFragment();
        }
    }

    private void goToMainContainerFragment() {
        MainContainerFragment mainContainerFragment = new MainContainerFragment();
        // Add Fragment to FrameLayout (flContainer), using FragmentManager
        fragmentTransaction = getSupportFragmentManager().beginTransaction();// begin  FragmentTransaction
        fragmentTransaction.replace(R.id.flContainer, mainContainerFragment);                                // add    Fragment
        fragmentTransaction.commit();
    }

    private void goToQuantityFragment() {
        QuantityFragment quantityFragment = new QuantityFragment();
        // Add Fragment to FrameLayout (flContainer), using FragmentManager
        fragmentTransaction = getSupportFragmentManager().beginTransaction();// begin  FragmentTransaction
        fragmentTransaction.replace(R.id.flContainer, quantityFragment);                                // add    Fragment
        fragmentTransaction.commit();
    }

    private void goToInspectionConclusionFragment() {
        InspectionConclusionFragment inspectionConclusionFragment = new InspectionConclusionFragment();
        // Add Fragment to FrameLayout (flContainer), using FragmentManager
        fragmentTransaction = getSupportFragmentManager().beginTransaction();// begin  FragmentTransaction
        fragmentTransaction.replace(R.id.flContainer, inspectionConclusionFragment);                                // add    Fragment
        fragmentTransaction.commit();
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            goToMainContainerFragment();
        } else if (id == R.id.nav_quantity) {
            // Handle the camera action
            goToQuantityFragment();
        } else if (id == R.id.nav_inspection_conclusion) {
            // Handle the camera action
            goToInspectionConclusionFragment();
        } else if (id == R.id.nav_conclusion) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
