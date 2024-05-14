package com.example.brtapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ProfileActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseFirestore db;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ImageView returnBtn=findViewById(R.id.arrow);


        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        db = FirebaseFirestore.getInstance();

        //DocumentReference userRef = db.collection("Users").document(mAuth.getCurrentUser().getUid());

        ImageView logout = findViewById(R.id.logout_rectangle);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ImageView delete_account = findViewById(R.id.delete_account_rectangle);

        delete_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.delete();
                db.collection("Users").document(mAuth.getCurrentUser().getUid()).delete();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

       /* userRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String email = documentSnapshot.getString("email");
                String full_name = documentSnapshot.getString("fullName");
                String dateOfBirth = documentSnapshot.getString("dateOfBirth");
                String phoneNumber = documentSnapshot.getString("phoneNumber");

                TextView full_name_text = findViewById(R.id.textoPerfil1);
                TextView dateOfBirth_text = findViewById(R.id.textoPerfil2);
                TextView phoneNumber_text = findViewById(R.id.textoPerfil3);
                TextView email_text = findViewById(R.id.textoPerfil4);

                full_name_text.setText(full_name);
                dateOfBirth_text.setText(dateOfBirth);
                phoneNumber_text.setText(phoneNumber);
                email_text.setText(email);
            }
        });*/

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, MainMenu.class));
                finish();
            }
        });


    }
}