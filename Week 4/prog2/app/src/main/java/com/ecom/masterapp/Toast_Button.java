package com.ecom.masterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Toast_Button extends AppCompatActivity {

    private Button b1,b2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        Toast.makeText(this, "On Create Toast", Toast.LENGTH_SHORT).show();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Toast_Button.this, "Button Toast", Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(Toast_Button.this, MainActivity.class);
                startActivity(main);
            }
        });

    }
}