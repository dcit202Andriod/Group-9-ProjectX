package com.example.Voting_APP;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login_register.R;
import com.example.login_register.landing_page;
import com.example.login_register.thank_you;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {

    TextView text_pres1;
    TextView text_pres2;
    TextView text_pres3;
    TextView text_pres4;


    Button voteButton;
    FirebaseAuth auth;
    FirebaseUser user;
    Button image_button;
    Button vote_btn;
    RadioButton rad_p1;
    RadioButton rad_p2;
    RadioButton rad_p3;
    RadioButton rad_p4;
    DataSnapshot dataSnapshot;

    DatabaseError databaseError;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    int i = 0;
    Member member;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        voteButton = findViewById(R.id.vote_btn);
        rad_p1 = findViewById(R.id.rad_p1);
        rad_p2 = findViewById(R.id.rad_p2);
        rad_p3 = findViewById(R.id.rad_p3);
        rad_p4 = findViewById(R.id.rad_p4);
        member = new Member(dataSnapshot, databaseError);
        firebaseDatabase = FirebaseDatabase.getInstance();
       auth = FirebaseAuth.getInstance();
       image_button = findViewById(R.id.Back_button);
       user = auth.getCurrentUser();

       if (user == null){
           Intent intent = new Intent(getApplicationContext(), login.class);
           startActivity(intent);
           finish();
       }

       reference = FirebaseDatabase.getInstance().getReference().child("SRC President");
      reference.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange( DataSnapshot snapshot) {
            if (snapshot.exists())
                i = (int)snapshot.getChildrenCount();

           }

           @Override
           public void onCancelled( DatabaseError error) {
               Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();


           }
       });


        voteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p1 = rad_p1.getText().toString();
                String p2 = rad_p2.getText().toString();
                String p3 = rad_p3.getText().toString();
                String p4 = rad_p4.getText().toString();

                if (rad_p1.isChecked()) {
                    member.setVote(p1);
                reference.child(String.valueOf(i+1)).setValue(member);
                } else {
                    member.setVote(p2);
                }

                if (rad_p2.isChecked()) {
                    member.setVote(p2);
                    reference.child(String.valueOf(i+1)).setValue(member);
                } else {
                    member.setVote(p2);
                }

                if (rad_p3.isChecked()) {
                    member.setVote(p3);
                    reference.child(String.valueOf(i+1)).setValue(member);
                } else {
                    member.setVote(p3);
                }

                if (rad_p4.isChecked()) {
                    member.setVote(p4);
                    reference.child(String.valueOf(i+1)).setValue(member);
                } else {
                    member.setVote(p1);
                }

                Toast.makeText(MainActivity.this, "Vote submitted", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), thank_you.class);
                startActivity(intent);
                finish();
            }
        });



        image_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), landing_page.class);
                startActivity(intent);
                finish();

            }
        });
    }
 }
