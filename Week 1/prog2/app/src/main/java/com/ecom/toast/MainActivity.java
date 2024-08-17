package com.ecom.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Default Toast Display", Toast.LENGTH_SHORT).show();
    }
    public void toast(View v){
        Toast.makeText(this, "Button Click Toast", Toast.LENGTH_SHORT).show();
    }

}