package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView tvTask, tvJenis, tvTime;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);




        tvTask = findViewById(R.id.rstask);
        tvJenis = findViewById(R.id.rsjtask);
        tvTime  = findViewById(R.id.ttask);

        Bundle bundle = getIntent().getExtras();

        String task = bundle.getString("a");
        String jenis = bundle.getString("b");
        String time = bundle.getString("c");

        tvTask.setText(task);
        tvJenis.setText(jenis);
        tvTime.setText(time);}}

