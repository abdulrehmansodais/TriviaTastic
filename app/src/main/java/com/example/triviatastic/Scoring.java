package com.example.triviatastic;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Scoring extends AppCompatActivity {

    private TextView scoreLabel;
    private TextView scoreValue;
    private Button saveButton;
    private String userName;
    private int userScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoring);
        Bundle extras = getIntent().getExtras();
        String username = getIntent().getStringExtra("username");
        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        int score=getIntent().getIntExtra("Score",0);
        Log.d(TAG, "loadUserData() email is " + username);
        Log.d(TAG, "loadUserData() email is " + score);
        scoreLabel = findViewById(R.id.score_label);
        scoreValue = findViewById(R.id.score_value);
        saveButton = findViewById(R.id.save_button);
        String score1=String.valueOf(score)+"/40";
        scoreValue.setText(score1);
        // Save user score and name to database or shared preferences
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Scoring.this,Dashboard.class);
                intent.putExtra("Username", username);
                intent.putExtra("name", name);
                intent.putExtra("email", email);

                startActivity(intent);
                finish();
            }
        });



    }
}