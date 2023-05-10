package com.example.triviatastic;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Dashboard extends AppCompatActivity {
    EditText user,name1,email1;
    Button StartQuiz,Logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Bundle extras = getIntent().getExtras();
        user=findViewById(R.id.username_edittext);
        name1=findViewById(R.id.name_edittext);
        email1=findViewById(R.id.email_edittext);
        StartQuiz= findViewById(R.id.Quiz);
        Logout= findViewById(R.id.logout);

            String username = getIntent().getStringExtra("username");
            String name = getIntent().getStringExtra("name");
            String email = getIntent().getStringExtra("email");
            user.setText(username);
            name1.setText(name);
            email1.setText(email);
           //The key argument here must match that used in the other activity

        StartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this,Quizcategory.class);
                intent.putExtra( "Username",username);
                intent.putExtra( "email",email);
                intent.putExtra( "name",name);
                startActivity(intent);
                finish();
            }
        });
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this,Login.class);
                startActivity(intent);
                finish();

            }
        });
    }
}