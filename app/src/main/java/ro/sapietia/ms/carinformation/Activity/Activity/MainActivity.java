package ro.sapietia.ms.carinformation.Activity.Activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import ro.sapietia.ms.carinformation.Activity.Fragment.AboutFragment;
import ro.sapietia.ms.carinformation.Activity.Fragment.LogOutFragment;
import ro.sapietia.ms.carinformation.Activity.Fragment.ProfileFragment;
import ro.sapietia.ms.carinformation.Activity.Fragment.SettingsFragment;
import ro.sapietia.ms.carinformation.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        int id = item.getItemId();

        switch(id){
            case R.id.about:{
                fragment = getSupportFragmentManager().findFragmentByTag("AboutFragment");

                if (fragment == null){
                    fragment = new AboutFragment();
                }
                loadFragment(fragment);
                return true;
            }
        }

        switch(id){
            case R.id.garage:{
                return true;
            }

        }

        switch (id){
            case R.id.logout:{

                fragment = getSupportFragmentManager().findFragmentByTag("LogOutFragment");

                if (fragment == null){
                fragment = new LogOutFragment();
                }
                loadFragment(fragment);
                return true;
            }
        }
        switch(id){
            case R.id.profile:{
                fragment = getSupportFragmentManager().findFragmentByTag("ProfileFragment");

                if (fragment == null){
                    fragment = new ProfileFragment();
                }
                loadFragment(fragment);
                return true;
            }
        }
        switch(id){
            case R.id.settings:{
                fragment = getSupportFragmentManager().findFragmentByTag("SettingsFragment");

                if (fragment == null){
                    fragment = new SettingsFragment();
                }
                loadFragment(fragment);
                return true;
            }
        }
        return true;
    }

    private void loadFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_main, fragment, fragment.getClass().getSimpleName());
        ft.commit();
    }
}
