package com.ecom.prog15;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String s1,s2;
    Double num1,num2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1= findViewById(R.id.button);
        Button b2= findViewById(R.id.button2);
        TextView t1= findViewById(R.id.textView3);
        EditText in1= findViewById(R.id.editTextNumberSigned);
        EditText in2=findViewById(R.id.editTextNumberSigned2);

        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                s1=in1.getText().toString();
                s2=in2.getText().toString();

                if(s1.isEmpty() || s2.isEmpty())
                    return;
                num1=Double.parseDouble(s1);
                num2= Double.parseDouble(s2);
                t1.setText("Result : "+(num1+num2));
                Toast.makeText(MainActivity.this, "Sum is "+(num1+num2), Toast.LENGTH_SHORT).show();
            }
        });

        b2.setOnClickListener(view -> {
            in1.getText().clear();
            in2.getText().clear();
            t1.setText("");
        });
    }
}