package ro.sapietia.ms.carinformation.Activity.Activity.Main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import ro.sapietia.ms.carinformation.R;

public class AddItemActivity extends AppCompatActivity {

     EditText licensePlateNumber;
     EditText serialNumber;
     Spinner category;
     Spinner model;
     Spinner brand;
     String categoryList [] = {"Car", "Motorcycle", "Truck"} ;
     String brandList [] = {"Opel", "Audi", "Volkswagen"};
     String modelList [] = {"Astra", "RS7", "Golf"};
     Button buttonNextAddItemActivity;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        buttonNextAddItemActivity = findViewById(R.id.buttonNextToInsuranceAddCarActivity);
        buttonNextAddItemActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(verification() == 1){
                    NavigationActivity.navigateToItemInformation(getApplicationContext());
                }
                //////////else
            }
        });

        licensePlateNumber = findViewById(R.id.LicensePlateNumber);
        serialNumber = findViewById(R.id.editTextSerialNumber);
        category = findViewById(R.id.spinnerCategoryAddCarActivity);
        model = findViewById(R.id.spinnerModelAddCarActivity);
        brand = findViewById(R.id.spinnerBrandAddCarActivity);

        ArrayAdapter<String> categoryArrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categoryList );
        categoryArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(categoryArrayAdapter);

        ArrayAdapter<String> brandArrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, brandList );
        brandArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brand.setAdapter(brandArrayAdapter);

        ArrayAdapter<String> modelArrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, modelList );
        modelArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        model.setAdapter(modelArrayAdapter);



    }

    private int verification() {

        if (licensePlateNumber.length() != 0 && serialNumber.length() != 0){

            return 0;
        }
        else
            return 1;
    }
}
