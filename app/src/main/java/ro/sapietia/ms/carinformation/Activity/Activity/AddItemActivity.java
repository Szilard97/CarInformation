package ro.sapietia.ms.carinformation.Activity.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
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


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        licensePlateNumber = findViewById(R.id.LicensePlateNumber);
        serialNumber = findViewById(R.id.editTextSerialNumber);
        category = findViewById(R.id.spinnerCategoryAddCarActivity);
        model = findViewById(R.id.spinnerModelAddCarActivity);
        brand = findViewById(R.id.spinnerBrandAddCarActivity);

        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categoryList );
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(arrayAdapter );

    }
}
