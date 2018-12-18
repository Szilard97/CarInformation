package ro.sapietia.ms.carinformation.Activity.Activity.Login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import ro.sapietia.ms.carinformation.Activity.Activity.Main.NavigationActivity;
import ro.sapietia.ms.carinformation.R;


public class LoginActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button=findViewById(R.id.buttonContinueLoginActivity);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                NavigationActivity.navigateToConfirm(getApplicationContext());
            }
        });

    }


}
