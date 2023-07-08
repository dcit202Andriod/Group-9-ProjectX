package com.example.login_register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.Voting_APP.MainActivity;
import com.example.Voting_APP.login;
import com.google.firebase.auth.FirebaseAuth;

public class landing_page extends AppCompatActivity {
    TextView textViewPresident;
    TextView textViewSecretary;
    TextView textViewTreasurer;
    TextView textViewLogout;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        textViewPresident = findViewById(R.id.text_president);
        textViewSecretary = findViewById(R.id.text_secretary);
        textViewTreasurer = findViewById(R.id.text_treasurer);
        textViewLogout = findViewById(R.id.log_out);

        textViewPresident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        textViewSecretary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), treasurer.class);
                startActivity(intent);
                finish();
            }
        });

        textViewTreasurer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), treasurer.class);
                startActivity(intent);
                finish();
            }
        });

        textViewLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
                finish();
            }
        });
    }


}