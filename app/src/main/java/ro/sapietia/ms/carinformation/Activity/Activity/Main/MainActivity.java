package ro.sapietia.ms.carinformation.Activity.Activity.Main;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import ro.sapietia.ms.carinformation.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private Fragment fragment;
    Button buttonAddItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAddItem = findViewById(R.id.buttonAddMainActivity);

        buttonAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavigationActivity.navigateToAddItem(getApplicationContext());
            }
        });

        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerView);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new MyAdapter(this, getData()));

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

    private ArrayList getData() {

        ArrayList<Car> cars = new ArrayList<>();

        Car car = new Car();


        car.setName("Opel");
        car.setImage(R.drawable.pic1);
        cars.add(car);

        car = new Car();
        car.setName("Audi");
        car.setImage(R.drawable.pic2);
        cars.add(car);

        car = new Car();
        car.setName("Mustang");
        car.setImage(R.drawable.pic3);
        cars.add(car);

        return  cars;

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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        switch(item.getItemId()){

            // Navigate to Interests
            case R.id.about:
                try {
                    NavigationActivity.navigateToAbout(MainActivity.this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case R.id.profile:
                try{
                    NavigationActivity.navigateToProfile(MainActivity.this);
                } catch (Exception e){
                    e.printStackTrace();
                }
                break;

            case R.id.logout:
                try{
                    NavigationActivity.navigateToLogout(MainActivity.this);
                } catch (Exception e){
                    e.printStackTrace();
                }
                break;
            case R.id.settings:
                try{
                    NavigationActivity.navigateToSettings(MainActivity.this);
                } catch (Exception e){
                    e.printStackTrace();
                }
                break;
        }

    return true;
    }
}
