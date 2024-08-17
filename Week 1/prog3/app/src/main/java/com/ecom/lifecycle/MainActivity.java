package com.ecom.lifecycle;

import static androidx.fragment.app.FragmentManager.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Activity Life Cycle","onCreate called");
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