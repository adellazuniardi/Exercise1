package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button bsignin,bregist;
    EditText enama,epassword;
    String nama,password;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bsignin=findViewById(R.id.btnsgnin);
        bregist=findViewById(R.id.btnregist);
        enama=findViewById(R.id.rdnama);
        epassword=findViewById(R.id.rdpassword);



        bsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = enama.getText().toString();
                password = epassword.getText().toString();

                String name = "Adel";
                String pass = "777";

                if (nama.isEmpty() || password.isEmpty()) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Name and Password is required!",
                            Toast.LENGTH_LONG);
                } else {
                    if (nama.equals(name) && pass.equals(pass)) {
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Success",
                                Toast.LENGTH_LONG);
                        t.show();

                        Bundle b = new Bundle();
                        b.putString("a", nama.trim());

                        Intent i = new Intent(getApplicationContext(), TaskActivity.class);
                        i.putExtras(b);
                        startActivity(i);

                    } else {

                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Failed", Toast.LENGTH_LONG);
                        t.show();
                    }
                }



            }
        });
        bregist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);
            }
        });

    }
}
