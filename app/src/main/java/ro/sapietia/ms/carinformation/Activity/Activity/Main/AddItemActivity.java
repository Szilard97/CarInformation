package ro.sapietia.ms.carinformation.Activity.Activity.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import ro.sapietia.ms.carinformation.R;

public class AddItemActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    Spinner categorySpinner;
    Spinner modelSpinner;
    Spinner brandSpinner;
    String categoryList[] = {"Empty", "Car", "Motorcycle", "Truck"};
    String brandListCar[] = {"Empty", "Opel", "Audi", "Volkswagen"};
    String brandListMotorcycle[] = {"Empty", "BMW", "Harley", "Suzuki"};
    String brandListTruck[] = {"Empty", "Volvo", "Scania"};
    String modelListOpel[] = {"Empty", "Astra", "Combo", "Corsa"};
    String modelListVolkswagen[] = {"Empty", "Passat", "Tiguan", "Golf"};
    String modelListAudi[] = {"Empty", "A4", "RS7", "Q7"};
    String modelListVolvo [] = {"First", "Second"};
    String modelListScania [] = {"First1", "Second2"};
    String modelListBMW [] = {"1", "2", "3" };
    String modelListHarley [] = {"11", "22", "33" };
    String modelListSuzuki [] = {"111", "222", "333" };
    Button buttonNextAddItemActivity;
    String toast = "Please enter a 'Category' or 'Brand' or 'Model'";
    String category;
    String brand;
    String model;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        initView();

    }

    private void initView() {
        categorySpinner = findViewById(R.id.spinnerCategoryAddCarActivity);
        modelSpinner = findViewById(R.id.spinnerModelAddCarActivity);
        brandSpinner = findViewById(R.id.spinnerBrandAddCarActivity);

        createSpinnerCategory();
        categorySpinner.setOnItemSelectedListener(this);
        brandSpinner.setOnItemSelectedListener(this);


        buttonNextAddItemActivity = findViewById(R.id.buttonNextToInsuranceAddCarActivity);
        buttonNextAddItemActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (categorySpinner.getSelectedItem().toString().equals("Empty") ||
                        brandSpinner.getSelectedItem().toString().equals("Empty") ||
                        modelSpinner.getSelectedItem().toString().equals("Empty")) {

                    Toast.makeText(getApplicationContext(), toast, Toast.LENGTH_LONG).show();
                } else {
                    category = categorySpinner.getSelectedItem().toString();
                    brand = brandSpinner.getSelectedItem().toString();
                    model = modelSpinner.getSelectedItem().toString();
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("Category", category);
                    resultIntent.putExtra("Brand", brand);
                    resultIntent.putExtra("Model", model);
                    setResult(RESULT_OK, resultIntent);
                    finish();

                }
            }
        });
    }

    private void createSpinnerBrandCar() {

                ArrayAdapter<String> brandArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, brandListCar);
                brandArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                brandSpinner.setAdapter(brandArrayAdapter);
    }

    private void createSpinnerBrandMotorcycle() {

        ArrayAdapter<String> brandArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, brandListMotorcycle);
        brandArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brandSpinner.setAdapter(brandArrayAdapter);
    }

    private void createSpinnerBrandTruck() {

        ArrayAdapter<String> brandArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, brandListTruck);
        brandArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brandSpinner.setAdapter(brandArrayAdapter);
    }

    private void createSpinnerModelOpel(){
        ArrayAdapter<String> modelArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, modelListOpel);
        modelArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modelSpinner.setAdapter(modelArrayAdapter);
    }

    private void createSpinnerModelAudi(){
        ArrayAdapter<String> modelArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, modelListAudi);
        modelArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modelSpinner.setAdapter(modelArrayAdapter);
    }

    private void createSpinnerModelVolkswagen(){
        ArrayAdapter<String> modelArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, modelListVolkswagen);
        modelArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modelSpinner.setAdapter(modelArrayAdapter);
    }

    private void createSpinnerModelVolvo(){
        ArrayAdapter<String> modelArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, modelListVolvo);
        modelArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modelSpinner.setAdapter(modelArrayAdapter);
    }

    private void createSpinnerModelScania(){
        ArrayAdapter<String> modelArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, modelListScania);
        modelArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modelSpinner.setAdapter(modelArrayAdapter);
    }

    private void createSpinnerModelBMW(){
        ArrayAdapter<String> modelArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, modelListBMW);
        modelArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modelSpinner.setAdapter(modelArrayAdapter);
    }

    private void createSpinnerModelSuzuki(){
        ArrayAdapter<String> modelArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, modelListSuzuki);
        modelArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modelSpinner.setAdapter(modelArrayAdapter);
    }

    private void createSpinnerModelHarley(){
        ArrayAdapter<String> modelArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, modelListHarley);
        modelArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modelSpinner.setAdapter(modelArrayAdapter);
    }

    private void createSpinnerCategory() {

                ArrayAdapter<String> categoryArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categoryList);
                categoryArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                categorySpinner.setAdapter(categoryArrayAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(parent.getId() == R.id.spinnerCategoryAddCarActivity) {
            if (position == 1) {
                createSpinnerBrandCar();
            }

            if (position == 2) {
                createSpinnerBrandMotorcycle();
            }

            if (position == 3) {
                createSpinnerBrandTruck();
            }
        }
         if(parent.getId() == R.id.spinnerBrandAddCarActivity ){

            if(position == 1 ){

                createSpinnerModelOpel();
            }

            if(position == 2 ){
                createSpinnerModelAudi();
            }

            if (position ==3 ){
                createSpinnerModelVolkswagen();
            }
        }
    }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}