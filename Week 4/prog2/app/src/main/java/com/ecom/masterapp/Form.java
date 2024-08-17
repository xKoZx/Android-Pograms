package com.ecom.masterapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Form extends AppCompatActivity {
    private TextView t1, t2;
    private Button b1,b2;
    private ImageView i1;
    private EditText ed1;
    private RadioButton r1, r2;
    private CheckBox c1, c2, c3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        t1 = findViewById(R.id.greeting1);
        t2 = findViewById(R.id.data1);
        i1 = findViewById(R.id.img1);
        b1 = findViewById(R.id.myButton);
        c1 = findViewById(R.id.checkBox1);
        c2 = findViewById(R.id.checkBox2);
        c3 = findViewById(R.id.checkBox3);
        ed1 = findViewById(R.id.nameInput);
        r1 = findViewById(R.id.radioMale);
        r2 = findViewById(R.id.radioFemale);
        b2=findViewById(R.id.form_back);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (is_Validate()) {
                    String name = ed1.getText().toString().trim();
                    String gender = r1.isChecked() ? "Male" : "Female";
                    StringBuilder hobbies = new StringBuilder();
                    if (c1.isChecked()) hobbies.append("Sports ");
                    if (c2.isChecked()) hobbies.append("Coding ");
                    if (c3.isChecked()) hobbies.append("Swimming ");

                    t1.setText("Hello " + name);
                    t2.setText(name + " is " + gender + " and interested in " + hobbies.toString().trim());

                    if (r1.isChecked()) {
                        i1.setImageResource(R.drawable.ai_boy);
                    } else if (r2.isChecked()) {
                        i1.setImageResource(R.drawable.ai_girl);
                    }

                    Toast.makeText(Form.this, "Submission Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(Form.this, MainActivity.class);
                startActivity(back);
            }
        });
    }

    public boolean is_Validate() {
        if (ed1.getText().toString().trim().isEmpty()) {
            Toast.makeText(Form.this, "Please enter name", Toast.LENGTH_SHORT).show();
        } else if (!r1.isChecked() && !r2.isChecked()) {
            Toast.makeText(Form.this, "Please select gender", Toast.LENGTH_SHORT).show();
        } else if (!c1.isChecked() && !c2.isChecked() && !c3.isChecked()) {
            Toast.makeText(Form.this, "Please check at least one interest", Toast.LENGTH_SHORT).show();
        } else {
            return true;
        }
        return false;
    }
}