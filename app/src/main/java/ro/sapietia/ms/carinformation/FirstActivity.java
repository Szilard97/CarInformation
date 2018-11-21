package ro.sapietia.ms.carinformation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Thread thread = new Thread(){

            public void run(){
                try {

                    sleep(1*1000);
                    Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(i);

                }
                catch(Exception exception){

                }
            }
        };
        thread.start();

    }


}
