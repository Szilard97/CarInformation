package ro.sapietia.ms.carinformation.Activity.Activity.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import ro.sapietia.ms.carinformation.Activity.Activity.Main.MainActivity;
import ro.sapietia.ms.carinformation.Activity.Activity.Main.NavigationActivity;
import ro.sapietia.ms.carinformation.R;


public class LoginActivity extends AppCompatActivity {

    private Button button;
    private FirebaseAuth mAuth;
    private EditText editTextEmail;
    private  EditText editTextPassword;
    private Button buttonLogin;
    private Button buttonRegister;
    private String email, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.Password);
        buttonRegister = findViewById(R.id.buttonRegistration);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = editTextEmail.getText().toString();
                password = editTextPassword.getText().toString();
                //ellenorzes

                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            //sign in
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

        mAuth = FirebaseAuth.getInstance();

        if(mAuth.getCurrentUser() !=null){
            mAuth.signOut();
        }

        //button=findViewById(R.id.buttonContinueLoginActivity);
        /*button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                NavigationActivity.navigateToMain(getApplicationContext());
            }
        });*/

    }

    @Override
    protected void onStart() {
        FirebaseUser currentUser = mAuth.getCurrentUser();

        super.onStart();

    }
}
