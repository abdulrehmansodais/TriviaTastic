package com.example.triviatastic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {

    private EditText nameEditText,passwordEditText,name1,email1;
    private Button signUpButton;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        FirebaseApp.initializeApp(this);
        nameEditText = findViewById(R.id.nameEditText);
        passwordEditText = findViewById(R.id.idEdtPassword);
        name1=findViewById(R.id.Name);
        email1=findViewById(R.id.Email);
        signUpButton = findViewById(R.id.signup);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("users");
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = nameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String  name= name1.getText().toString();
                String  email= email1.getText().toString();
                User user = new User(name,password,username,email);
                databaseReference.child(name).setValue(user);
                Intent intent = new Intent(Signup.this,Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
