package ro.sapietia.ms.carinformation.Activity.Activity.Menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;

import ro.sapietia.ms.carinformation.R;

public class SettingsActivity extends AppCompatActivity {

    private Spinner country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        setContentView(R.layout.activity_settings);
        country = (Spinner) findViewById(R.id.spinnerCountrySettingsActivity);

        Locale [] locales = Locale.getAvailableLocales();
        ArrayList<String> countries = new ArrayList<String>();

        for (Locale locale: locales){
            String country = locale.getDisplayCountry();
            if(country.trim().length() > 0 && !countries.contains(country)){

                countries.add(country);
            }
        }
        Collections.sort(countries);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, countries);
        // set the view for the Drop down list
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // set the ArrayAdapter to the spinner
        country.setAdapter(dataAdapter);
        country.setSelection(37);

        System.out.println("# countries found: " + countries.size());
    }


}
