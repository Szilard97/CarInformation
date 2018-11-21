package ro.sapietia.ms.carinformation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmActivity extends AppCompatActivity {

    private Button button;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        button=findViewById(R.id.buttonConfirmActivity);
        tv = findViewById(R.id.textViewTermsAndConditions);



        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        tv.setOnClickListener(new  View.OnClickListener(){

            @Override
            public void onClick(View v){

                Intent j = new Intent(getApplicationContext(), TermsAndConditions.class);
                startActivity(j);
            }
        });
    }

}
