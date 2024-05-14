package com.example.brtapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegisterActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        mAuth=FirebaseAuth.getInstance();
        db=FirebaseFirestore.getInstance();
        ImageView returnBtn=findViewById(R.id.arrow);
        Button button = findViewById(R.id.button_reg);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.email_reg);
                EditText editText1 = findViewById(R.id.password_reg);
                EditText editText2 = findViewById(R.id.card_number_reg);
                EditText editText3 = findViewById(R.id.phone_number_reg);
                EditText editText4 = findViewById(R.id.date_birth_reg);
                EditText editText6 = findViewById(R.id.full_name_reg);

                String email = editText.getText().toString();
                String password = editText1.getText().toString();
                String card_number = editText2.getText().toString();
                String phone_number = editText3.getText().toString();
                String date_birth = editText4.getText().toString();
                String full_name = editText6.getText().toString();

                User user = new User(email, password, full_name, date_birth, card_number, phone_number);

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    db.collection("Users").document(mAuth.getCurrentUser().getUid()).set(user)
                                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                        @Override
                                                        public void onSuccess(Void unused) {
                                                            Toast.makeText(RegisterActivity.this, "Account created.",
                                                                    Toast.LENGTH_SHORT).show();
                                                            Intent intent = new Intent(getApplicationContext(), MainMenu.class);
                                                            startActivity(intent);
                                                            finish();
                                                        }
                                                    })
                                                    .addOnFailureListener(new OnFailureListener() {
                                                        @Override
                                                        public void onFailure(@NonNull Exception e) {
                                                            Toast.makeText(RegisterActivity.this, "Failed to create account.",
                                                                    Toast.LENGTH_SHORT).show();
                                                        }
                                                    });
                                } else {
                                    Toast.makeText(RegisterActivity.this, "Failed to create account.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, MainMenu.class));
                finish();
            }
        });
    }
}