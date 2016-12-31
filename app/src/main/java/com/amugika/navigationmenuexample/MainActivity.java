package com.amugika.navigationmenuexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.pkmmte.view.CircularImageView;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private CircularImageView imageView;
    private TextView name_header_main_menuTextView, email_header_main_menuTextView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View header = navigationView.getHeaderView(0);

        imageView = (CircularImageView) header.findViewById(R.id.imageView);

        Picasso.with(MainActivity.this).load("https://lh3.googleusercontent.com/-hb5gQLnhlH0/AAAAAAAAAAI/AAAAAAAAPS8/n--TGUrH7lA/s240-c/photo.jpg").into(imageView);



        name_header_main_menuTextView = (TextView) header.findViewById(R.id.name_header_main_menuTextView);

        email_header_main_menuTextView = (TextView) header.findViewById(R.id.email_header_main_menuTextView);

        name_header_main_menuTextView.setText("Anartz");
        email_header_main_menuTextView.setText("mugan86@gmail.com");
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

        String title = toolbar.getTitle().toString();
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_main) title = "Start activity";
        else if (id == R.id.nav_what_is_servirace) title = "What is Servirace";
        else if (id == R.id.nav_app_preferences) title = "Configuration";
        else if (id == R.id.nav_versions) title = "Versions";
        else if (id == R.id.nav_about_author) title = "About author";
        else if (id == R.id.nav_contact) title = "Contact";
        else if (id == R.id.nav_search_races) title = "Search races";
        else if (id == R.id.nav_next_races) title = "Next races";
        else if (id == R.id.nav_past_races) title = "Past races";
        else if (id == R.id.nav_near_races) title = "Near Races";
        else if (id == R.id.nav_suggest_races) title = "Suggest races";
        else if (id == R.id.nav_running_calculator) title = "Running calculator";
        else if (id == R.id.nav_traffic_info) title = "Traffic info";
        else if (id == R.id.nav_colaborate) title = "Colaborate";
        else if (id == R.id.nav_share_app) title = "Share App";
        else if (id == R.id.nav_valoration) title = "Valorate app";
        else if (id == R.id.nav_change_language) title = "Change language";
        else if (id == R.id.nav_champions) title = "Champions";

        toolbar.setTitle(title);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
