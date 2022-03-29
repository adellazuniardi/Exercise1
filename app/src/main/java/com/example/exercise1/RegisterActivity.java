package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class RegisterActivity extends AppCompatActivity {


        EditText efnama, efemail, efpass, efrepass;
        Button btregis;
        String nama, email, password, repass;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register);

            btregis = findViewById(R.id.rbtn);
            efnama = findViewById(R.id.renama);
            efemail = findViewById(R.id.reemail);
            efpass = findViewById(R.id.repass);
            efrepass = findViewById(R.id.rerepass);

            btregis.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    nama = efnama.getText().toString();
                    email = efemail.getText().toString();
                    password = efpass.getText().toString();
                    repass = efrepass.getText().toString();


                    if (efnama.getText().toString().length() == 0) {
                        efnama.setError("Name Needed!");
                    }
                    if (efemail.getText().toString().length() == 0) {
                        efemail.setError("Email Needed!");
                    }
                    if (efpass.getText().toString().length() == 0) {
                        efpass.setError("Password Needed!");
                    }
                    if (efrepass.getText().toString().length() == 0) {
                        efrepass.setError("Re-Password Needed!");
                    } else {
                        if (efpass.getText().toString().equals(efrepass.getText().toString())) {
                            Toast t = Toast.makeText(getApplicationContext(),
                                    "Registration Succes", Toast.LENGTH_LONG);
                            t.show();

                            Bundle b = new Bundle();
                            b.putString("a", nama.trim());

                            Intent i = new Intent(getApplicationContext(), TaskActivity.class);
                            i.putExtras(b);
                            startActivity(i);
                        } else {
                            Snackbar.make(view, "Password and Re Password must be same!",
                                    Snackbar.LENGTH_LONG).show();
                        }

                    }
                }

            });
        }
    }

