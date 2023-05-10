package com.example.triviatastic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Quizcategory extends AppCompatActivity {
    private RadioGroup answerRadioGroup;
    private Button startquiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizcategory);
        Bundle extras = getIntent().getExtras();
        String username = getIntent().getStringExtra("username");
        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        startquiz=findViewById(R.id.start_quiz_button);
        answerRadioGroup = findViewById(R.id.quiz_category);
        startquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answerRadioGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(Quizcategory.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                } else {
                    // Check if answer is correct
                    int selectedAnswerIndex = answerRadioGroup.indexOfChild(findViewById(answerRadioGroup.getCheckedRadioButtonId()));
                    Intent intent = new Intent(Quizcategory.this, QuizActivity.class);
                    intent.putExtra("Username", username);
                    intent.putExtra("email", email);
                    intent.putExtra("name", name);
                    intent.putExtra("ans", selectedAnswerIndex);
                    startActivity(intent);
                }
            }
        });
    }
}