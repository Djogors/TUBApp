package com.example.brtapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainMenu extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_menu);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        ImageView logoTub = findViewById(R.id.logo);

        logoTub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, MainMenu.class));
                finish();
            }
        });

        ImageView back = findViewById(R.id.arrow_header);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainMenu.this, MainActivity.class));
                finish();
            }
        });

        ImageView profile_rectangle = findViewById(R.id.profile_rectangle);


        profile_rectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user == null){
                    Toast.makeText(MainMenu.this, "You need to be signed in to access this area.",
                            Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(MainMenu.this, ProfileActivity.class));
                }
            }
        });
    }
}