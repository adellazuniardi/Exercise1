package com.example.exercise1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class TaskActivity extends AppCompatActivity {

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            if (item.getItemId() == R.id.onSubmit)
                task = Etask.getText().toString();
            jenis = Ejenis.getText().toString();
            time = Etime.getText().toString();

            if (Etask.getText().toString().length()==0){
                Etask.setError("Task Required!");
            }
            if (Ejenis.getText().toString().length()==0){
                Ejenis.setError("Jenis Task Required!");
            }
            if (Etime.getText().toString().length()==0){
                Etime.setError("Time Task Required!");
            }
            if (task.isEmpty() || jenis.isEmpty() || time.isEmpty()) {
                Toast t = Toast.makeText(getApplicationContext(),
                        "Fill All The Data!", Toast.LENGTH_LONG);
                t.show();
            } else {
                Toast t = Toast.makeText(getApplicationContext(),
                        "Success", Toast.LENGTH_LONG);
                t.show();

                Bundle b = new Bundle();

                b.putString("a", task.trim());
                b.putString("b", jenis.trim());
                b.putString("c", time.trim());
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                i.putExtras(b);
                startActivity(i);
            }
            if (item.getItemId() == R.id.mnLogOut) {
                Intent l = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(l);
            }

            return super.onOptionsItemSelected(item);
        }

        EditText Etask, Ejenis, Etime;
        FloatingActionButton fab;
        String task, jenis, time;
        TextView username;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_task);

            Etask = findViewById(R.id.Ttask);
            Ejenis = findViewById(R.id.Tjenis);
            Etime = findViewById(R.id.Tmtask);
            username = findViewById(R.id.usname);

            Bundle bundle = getIntent().getExtras();

            String user = bundle.getString("a");
            username.setText(user);

            fab = findViewById(R.id.fabsimpan);
            fab.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){

                    task = Etask.getText().toString();
                    jenis = Ejenis.getText().toString();
                    time = Etime.getText().toString();

                    if(task.isEmpty() || jenis.isEmpty() || time.isEmpty())
                    {
                        Snackbar.make(view, "Fill All The Data!", Snackbar.LENGTH_LONG).show();
                    }
                    else{
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Success", Toast.LENGTH_LONG);
                        t.show();

                        Bundle b = new Bundle();

                        b.putString("a", task.trim());
                        b.putString("b", jenis.trim());
                        b.putString("c", time.trim());
                        Intent i = new Intent(getApplicationContext(), ResultActivity.class);
                        i.putExtras(b);
                        startActivity(i);
                    }
                }
            });
        }



    }
