package ro.sapietia.ms.carinformation.Activity.Activity.Main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import ro.sapietia.ms.carinformation.R;

public class AddItemActivity extends AppCompatActivity implements Serializable {

     Spinner category;
     Spinner model;
     Spinner brand;
     String categoryList [] = {"Empty", "Car", "Motorcycle", "Truck"} ;
     String brandList [] = {"Empty","Opel", "Audi", "Volkswagen"};
     String modelList [] = {"Empty","Astra", "RS7", "Golf"};
     Button buttonNextAddItemActivity;
     String toast =  "Please enter a 'Category' or 'Brand' or 'Model'";
     ArrayList<Vehicle> vehicles;
     Car car;
     Truck truck;
     Motorcycle motorcycle;

     

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        vehicles = new ArrayList<>();

        category = findViewById(R.id.spinnerCategoryAddCarActivity);
        model = findViewById(R.id.spinnerModelAddCarActivity);
        brand = findViewById(R.id.spinnerBrandAddCarActivity);

        ArrayAdapter<String> categoryArrayAdapter= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categoryList );
        categoryArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(categoryArrayAdapter);

        ArrayAdapter<String> brandArrayAdapter= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, brandList );
        brandArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brand.setAdapter(brandArrayAdapter);

        ArrayAdapter<String> modelArrayAdapter= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, modelList );
        modelArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        model.setAdapter(modelArrayAdapter);

        buttonNextAddItemActivity = findViewById(R.id.buttonNextToInsuranceAddCarActivity);
        buttonNextAddItemActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( verification(category.getSelectedItem().toString(), brand.getSelectedItem().toString(), model.getSelectedItem().toString() )){
                    if(category.equals("Car")){
                        car = new Car(brand.getSelectedItem().toString(), model.getSelectedItem().toString());
                        vehicles.add(car);
                        NavigationActivity.navigateToItemInformation(getApplicationContext());
                    }
                    else if (category.equals("Motorcycle")){
                        motorcycle = new Motorcycle(brand.getSelectedItem().toString(), model.getSelectedItem().toString());
                        vehicles.add(motorcycle);
                        NavigationActivity.navigateToItemInformation(getApplicationContext());
                    }
                    else{
                        truck = new Truck(brand.getSelectedItem().toString(), model.getSelectedItem().toString());
                        NavigationActivity.navigateToItemInformation(getApplicationContext());
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),toast ,Toast.LENGTH_LONG).show();

                }
            }
        });
    }


    public boolean verification(String category, String brand, String model) {

        if(category.equals("Empty") || brand.equals("Empty") || model.equals("Empty")){

            return false;
        }
        return true;
    }


/*public void startSend(View v){
        Intent i = new Intent(AddItemActivity.this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("vehicles", vehicles );
        i.putExtras(bundle);
        startActivity(i);
    }*/
}