package com.ecom.masterapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SumApp extends AppCompatActivity {

    private EditText num1, num2;
    private TextView resultText;
    private Button calculateButton, resetButton, back;

    private ImageView i1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum_app);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        resultText = findViewById(R.id.resultText);
        calculateButton = findViewById(R.id.calculateButton);
        resetButton = findViewById(R.id.resetButton);
        back=findViewById(R.id.bt_back);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSum();

            }
        });

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               calculateSum();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetFields();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(SumApp.this, MainActivity.class);
                startActivity(back);
            }
        });
    }

    private void calculateSum() {
        String num1Str = num1.getText().toString();
        String num2Str = num2.getText().toString();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            int number1 = Integer.parseInt(num1Str);
            int number2 = Integer.parseInt(num2Str);
            int sum = number1 + number2;
            resultText.setText("Result: " + sum);
            Toast.makeText(this, "Sum: " + sum, Toast.LENGTH_SHORT).show();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
        }
    }
    private void resetFields() {
        num1.setText("");
        num2.setText("");
        resultText.setText("Result:");
    }
}