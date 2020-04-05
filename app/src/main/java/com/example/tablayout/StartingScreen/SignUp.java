package com.example.tablayout.StartingScreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tablayout.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {

    Button create;
    FirebaseAuth auth;
    EditText email;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        auth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        create = findViewById(R.id.create);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String Email = email.getText().toString().trim();
                String Password = password.getText().toString().trim();



                if (Email.isEmpty()){
                    email.setError("Email is Required");
                    email.requestFocus();
                    return;

                }
                if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
                    email.setError("please Enter a Valid email");
                    email.requestFocus();
                    return;
                }

                if (Password.length()<6){
                    password.setError("Minimum length is 6");
                    password.setError("Email is Required");
                    password.requestFocus();
                }

                if (Password.isEmpty()){
                    password.setError("password is Required");

                    password.requestFocus();

                }


                auth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(SignUp.this, "SucessFull", Toast.LENGTH_SHORT).show();
                        }

                        else
                        if (task.getException() instanceof FirebaseAuthUserCollisionException){
                            Toast.makeText(SignUp.this, "User is already Registered", Toast.LENGTH_SHORT).show();
//                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = auth.getCurrentUser();
//                            updateUI(user);
                        }

                        else {

                            Toast.makeText(SignUp.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });






            }



        });
    }

}
