package com.ecom.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText ed1;
    private RadioButton r1, r2;
    private RadioGroup radioGroupGender;
    private CheckBox c1, c2, c3;
    private ToggleButton toggleButton;

    private String originalName;
    private boolean originalGenderMale;
    private boolean originalGenderFemale;
    private boolean originalCheckBox1;
    private boolean originalCheckBox2;
    private boolean originalCheckBox3;
    private boolean isDataSaved = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.nameInput);
        r1 = findViewById(R.id.radioMale);
        r2 = findViewById(R.id.radioFemale);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        c1 = findViewById(R.id.checkBox1);
        c2 = findViewById(R.id.checkBox2);
        c3 = findViewById(R.id.checkBox3);
        Button b1 = findViewById(R.id.myButton);
        toggleButton = findViewById(R.id.toggleButton);

        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (!isChecked) {
                if (isDataSaved) {
                    restoreData();
                }
            } else {
                saveOriginalData();
                resetData();
            }
        });

        b1.setOnClickListener(view -> {
            if (is_Validate()) {
                String name = ed1.getText().toString().trim();
                String gender = r1.isChecked() ? "Male" : "Female";
                StringBuilder hobbies = new StringBuilder();
                if (c1.isChecked()) hobbies.append("Sports ");
                if (c2.isChecked()) hobbies.append("Coding ");
                if (c3.isChecked()) hobbies.append("Swimming ");

                int imageResId = r1.isChecked() ? R.drawable.ai_boy : R.drawable.ai_girl;
                String welcomeMessage = "Hello " + name + "!";
                int backgroundColor = Color.YELLOW;

                Intent intent = new Intent(MainActivity.this, displayActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("gender", gender);
                intent.putExtra("hobbies", hobbies.toString().trim());
                intent.putExtra("imageResId", imageResId);
                intent.putExtra("welcomeMessage", welcomeMessage);
                intent.putExtra("backgroundColor", backgroundColor);
                startActivity(intent);
            }
        });
    }

    private void saveOriginalData() {
        originalName = ed1.getText().toString().trim();
        originalGenderMale = r1.isChecked();
        originalGenderFemale = r2.isChecked();
        originalCheckBox1 = c1.isChecked();
        originalCheckBox2 = c2.isChecked();
        originalCheckBox3 = c3.isChecked();
        isDataSaved = true;
    }

    private void restoreData() {
        ed1.setText(originalName);
        if (originalGenderMale) {
            radioGroupGender.check(r1.getId());
        } else if (originalGenderFemale) {
            radioGroupGender.check(r2.getId());
        }
        c1.setChecked(originalCheckBox1);
        c2.setChecked(originalCheckBox2);
        c3.setChecked(originalCheckBox3);
    }

    private void resetData() {
        ed1.setText("");
        radioGroupGender.clearCheck();
        c1.setChecked(false);
        c2.setChecked(false);
        c3.setChecked(false);
    }

    public boolean is_Validate() {
        if (ed1.getText().toString().trim().isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter name", Toast.LENGTH_SHORT).show();
        } else if (!r1.isChecked() && !r2.isChecked()) {
            Toast.makeText(MainActivity.this, "Please select gender", Toast.LENGTH_SHORT).show();
        } else if (!c1.isChecked() && !c2.isChecked() && !c3.isChecked()) {
            Toast.makeText(MainActivity.this, "Please check at least one interest", Toast.LENGTH_SHORT).show();
        } else {
            return true;
        }
        return false;
    }
}
