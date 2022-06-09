package com.example.mad_final_example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mad_final_example.Database.DBHandler;

public class Home extends AppCompatActivity {

    EditText username,password;
    Button register,login;

    // Register User
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        username =findViewById(R.id.etUserNameH);
        password=findViewById(R.id.etPasswordH);
        login=findViewById(R.id.btnLoginH);
        register=findViewById(R.id.btnRegisterH);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i =new Intent(getApplicationContext(),ProfileManagement.class);
                startActivity(i);
            }
        });


        //Login User
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBHandler dbHandler = new DBHandler(getApplicationContext());
                if (dbHandler.loginUser(username.getText().toString(), password.getText().toString())) {
                    Toast.makeText(Home.this, "Successfully", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), EditProfile.class);
                    startActivity(i);
                } else {
                    Toast.makeText(Home.this, "No user or Invalid User Details", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}