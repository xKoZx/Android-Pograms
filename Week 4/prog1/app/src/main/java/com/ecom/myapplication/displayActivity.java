package com.ecom.myapplication;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class displayActivity extends AppCompatActivity {

    private TextView resultText, welcomeText, infoText;
    private ImageView resultImage;
    private Button backButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);


        welcomeText = findViewById(R.id.welcomeText);
        resultText = findViewById(R.id.resultText);
        resultImage = findViewById(R.id.resultImage);
        infoText = findViewById(R.id.infoText);
        backButton = findViewById(R.id.backButton);


        String name = getIntent().getStringExtra("name");
        String gender = getIntent().getStringExtra("gender");
        String hobbies = getIntent().getStringExtra("hobbies");
        int imageResId = getIntent().getIntExtra("imageResId", -1);
        String welcomeMessage = getIntent().getStringExtra("welcomeMessage");
        int backgroundColor = getIntent().getIntExtra("backgroundColor", Color.WHITE);


        welcomeText.setText(welcomeMessage);
        welcomeText.setBackgroundColor(backgroundColor);


        resultText.setText(name + " is " + gender + " and interested in " + hobbies);
        if (imageResId != -1) {
            resultImage.setImageResource(imageResId);
        }


        infoText.setText("Here is your detailed information.");


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
