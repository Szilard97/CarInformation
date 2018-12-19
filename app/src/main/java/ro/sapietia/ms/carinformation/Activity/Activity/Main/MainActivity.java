package ro.sapietia.ms.carinformation.Activity.Activity.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import ro.sapietia.ms.carinformation.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ArrayList<Car> mCars;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    Button buttonAddItem;
    String category;
    String brand;
    String model;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCars = new ArrayList<>();
        buttonAddItem = findViewById(R.id.buttonAddMainActivity);

        buttonAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, AddItemActivity.class);
                startActivityForResult(intent,1);


            }
        });
        }

    private void createList( String brand, String model) {

        mCars.add(new Car(brand, model, R.drawable.pic1));
        buildRecyclerView();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode ==1){
            if(resultCode == RESULT_OK){
                category = data.getStringExtra("Category");
                brand = data.getStringExtra("Brand");
                model = data.getStringExtra("Model");
                createList(brand, model);

            }
        }

    }

    private void buildRecyclerView() {

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MyAdapter(getApplicationContext(), mCars);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    /*private void createExampleList() {
        mCars = new ArrayList<>();
        mCars.add(new Car("Opel", "Astra", R.drawable.pic1));
       //mCars.add(new Car("Audi", "A4", R.drawable.pic2));
    }*/

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


    /*
    String category;
    String brand;
    String model;

*brand1 = brand.getText().toString();
                model1 = model.getText().toString();
                inserItem(count, brand1, model1);
                count +=1;
                 NavigationActivity.navigateToAddItem(getApplicationContext());
                 Bundle b = getIntent().getExtras();
                 brand1 = b.getString("Brand");
                 model1 = b.getString("Model");
                 inserItem(count, brand1,mode1l);


   ArrayList<Car> cars = null;
   Car car = null;
    private void listElements(String a, String b) {
        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerView);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new MyAdapter(this, getData1(a, b)));
    }

    private ArrayList<Car> getData() {

        if(cars == null){
            cars = new ArrayList<>();
        }
        car = new Car("Opel", "Astra");
        //car.setImage(R.drawable.pic1);
        cars.add(car);

        return  cars;
    }
    private ArrayList<Car> getData1(String name1, String name2) {

        if(cars == null){
            cars = new ArrayList<>();
        }
        car = new Car(name1, name2);
        car.setImage(R.drawable.pic1);
        cars.add(car);


        return  cars;
    }
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


                buttonAddItem = findViewById(R.id.buttonAddMainActivity);
                buttonAddItem.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {

        NavigationActivity.navigateToAddItem(getApplicationContext());
        Bundle b = getIntent().getExtras();
        category = b.getString("Category");
        brand = b.getString("Brand");
        model = b.getString("Model");
        }
        });*/



