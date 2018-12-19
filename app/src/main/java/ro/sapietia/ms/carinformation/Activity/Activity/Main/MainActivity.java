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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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


    DatabaseReference mDatabase;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("Test").setValue("gtcfktgcdlytcdlkytd");

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
