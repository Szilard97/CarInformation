package ro.sapietia.ms.carinformation.Activity.Activity.Login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ro.sapietia.ms.carinformation.Activity.Activity.Main.NavigationActivity;
import ro.sapietia.ms.carinformation.R;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Thread thread = new Thread(){

            public void run(){
                try {

                    sleep(1*1000);
                    NavigationActivity.navigateToLogIn(getApplicationContext());

                }
                catch(Exception exception){

                }
            }
        };
        thread.start();

    }


}
