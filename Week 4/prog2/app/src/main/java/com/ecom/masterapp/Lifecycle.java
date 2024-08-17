package com.ecom.masterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Lifecycle extends AppCompatActivity {
    private Button b1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        Log.d("Activity Life Cycle","onCreate called");

        b1=findViewById(R.id.life_back);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(Lifecycle.this, MainActivity.class);
                startActivity(back);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Activity Life Cycle", "onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Activity Life Cycle", "onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Activity Life Cycle", "onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Activity Life Cycle", "onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Activity Life Cycle", "onDestroy called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Activity Life Cycle", "onRestart called");
    }

}