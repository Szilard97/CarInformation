package ro.sapietia.ms.carinformation.Activity.Activity.Main;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

import ro.sapietia.ms.carinformation.R;

public class AddItemActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    private Spinner categorySpinner;
    private Spinner modelSpinner;
    private Spinner brandSpinner;
    private String categoryList[] = {"Empty", "Car", "Motorcycle", "Truck"};
    private String brandListCar[] = {"Empty", "Opel", "Audi", "Volkswagen"};
    private String brandListMotorcycle[] = {"Empty", "BMW", "Harley", "Suzuki"};
    private String brandListTruck[] = {"Empty", "Volvo", "Scania"};
    private String modelListOpel[] = {"Empty", "Astra", "Combo", "Corsa"};
    private String modelListVolkswagen[] = {"Empty", "Passat", "Tiguan", "Golf"};
    private String modelListAudi[] = {"Empty", "A4", "RS7", "Q7"};
    private String modelListVolvo [] = {"First", "Second"};
    private String modelListScania [] = {"First1", "Second2"};
    private String modelListBMW [] = {"1", "2", "3" };
    private String modelListHarley [] = {"11", "22", "33" };
    private String modelListSuzuki [] = {"111", "222", "333" };
    private Button buttonNextAddItemActivity;
    private String toast = "Please enter a 'Category' or 'Brand' or 'Model'";
    private String category;
    private String brand;
    private String model;
    private String insurance;
    private String PTR;
    private String vignette;
    private EditText editTextInsurance;
    private EditText editTextEditDatePeriodicTechnicalReviews;
    private EditText editDateVignette;
    private int year_x, month_x, day_x;
    private final int DILOG_ID = 0;
    private int a = 0, b = 0, c = 0;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        final Calendar cal = Calendar.getInstance();

        year_x= cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);

        initializeFields();
        showDialogOnButtonClick();
        initView();
    }

    public void showDialogOnButtonClick(){
        editTextInsurance = findViewById(R.id.editDateInsuranceItemInformationActivity);
        editTextEditDatePeriodicTechnicalReviews = findViewById(R.id.editDatePeriodicTechnicalReviews);
        editDateVignette = findViewById(R.id.editDateVignette);

        editTextInsurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DILOG_ID);
                a = 1;
            }
        });
        editTextEditDatePeriodicTechnicalReviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DILOG_ID);
                b = 1;
            }

        });
        editDateVignette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DILOG_ID);
                c = 1;
            }
        });
    }

    protected Dialog onCreateDialog(int id){

        if(id == DILOG_ID)
            return new DatePickerDialog(this, dpickerListner, year_x, month_x, day_x);
        return null;
    }

    private DatePickerDialog.OnDateSetListener dpickerListner = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            year_x = year;
            month_x = monthOfYear+1;
            day_x = dayOfMonth;

            if(a ==1){
                editTextInsurance.setText(year_x + "-" +month_x + "-" +day_x );
                a = 0;
            }else if(b ==1){
                editTextEditDatePeriodicTechnicalReviews.setText(year_x + "-" +month_x + "-" +day_x );
                b = 0;
            }
            else if(c ==1){
                editDateVignette.setText(year_x + "-" +month_x + "-" +day_x );
                c =0;
            }

        }
    };


    private void initializeFields() {

        categorySpinner = findViewById(R.id.spinnerCategoryAddCarActivity);
        modelSpinner = findViewById(R.id.spinnerModelAddCarActivity);
        brandSpinner = findViewById(R.id.spinnerBrandAddCarActivity);
        editTextInsurance =findViewById(R.id.editDateInsuranceItemInformationActivity);
        editTextEditDatePeriodicTechnicalReviews = findViewById(R.id.editDateInsuranceItemInformationActivity);
        editDateVignette = findViewById(R.id.editDateVignette);
        createSpinnerCategory();
        categorySpinner.setOnItemSelectedListener(this);
        brandSpinner.setOnItemSelectedListener(this);
        buttonNextAddItemActivity = findViewById(R.id.buttonNextToInsuranceAddCarActivity);
    }

    private void initView() {

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
                    vignette = editDateVignette.getText().toString();
                    PTR = editTextEditDatePeriodicTechnicalReviews.getText().toString();
                    insurance = editTextInsurance.getText().toString();
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("Vignette", vignette);
                    resultIntent.putExtra("PTR", PTR);
                    resultIntent.putExtra("Insurance", insurance);
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