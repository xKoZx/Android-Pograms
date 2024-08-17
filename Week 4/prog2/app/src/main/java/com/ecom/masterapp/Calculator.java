package com.ecom.masterapp;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {

    private EditText editText;
    private String input = "";
    private String operator = "";
    private double firstValue = Double.NaN;
    private double secondValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        editText = findViewById(R.id.editText);

        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonSubtract = findViewById(R.id.buttonSubtract);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonDivide = findViewById(R.id.buttonDivide);
        Button buttonEquals = findViewById(R.id.buttonEquals);
        Button buttonDot = findViewById(R.id.buttonDot);
        Button buttonC = findViewById(R.id.buttonC);
        Button back=findViewById(R.id.back);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                input += b.getText().toString();
                editText.setText(input);
            }
        };

        button0.setOnClickListener(listener);
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);
        buttonDot.setOnClickListener(listener);

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = "";
                operator = "";
                firstValue = Double.NaN;
                secondValue = Double.NaN;
                editText.setText("");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                operator = "+";
                input = "";
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                operator = "-";
                input = "";
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                operator = "*";
                input = "";
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                operator = "/";
                input = "";
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                operator = "";
                editText.setText(String.valueOf(firstValue));
                input = String.valueOf(firstValue);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(Calculator.this, MainActivity.class);
                startActivity(back);
            }
        });
    }

    private void compute() {
        if (!Double.isNaN(firstValue)) {
            if (!input.isEmpty()) {
                secondValue = Double.parseDouble(input);
                switch (operator) {
                    case "+":
                        firstValue = firstValue + secondValue;
                        break;
                    case "-":
                        firstValue = firstValue - secondValue;
                        break;
                    case "*":
                        firstValue = firstValue * secondValue;
                        break;
                    case "/":
                        firstValue = firstValue / secondValue;
                        break;
                }
            }
        } else {
            if (!input.isEmpty()) {
                firstValue = Double.parseDouble(input);
            }
        }
    }
}