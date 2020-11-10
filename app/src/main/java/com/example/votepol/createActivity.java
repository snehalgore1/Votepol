package com.example.votepol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class createActivity extends AppCompatActivity {
    Button createvote;
    Button castvote;
    Button createpoll;
    Button castpoll;
    Button logout;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        createvote=findViewById(R.id.btncreatevote);
        castvote=findViewById(R.id.btncastevote);
        createpoll=findViewById(R.id.btncreatepoll);
        castpoll=findViewById(R.id.btncastpoll);
        logout=findViewById(R.id.btnlogout);

        firebaseAuth=FirebaseAuth.getInstance();
        firebaseUser=firebaseAuth.getCurrentUser();

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(createActivity.this,MainActivity.class));
            }
        });
    }
}