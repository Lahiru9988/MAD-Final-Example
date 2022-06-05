package com.example.mad_final_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.mad_final_example.Database.DBHandler;

import java.util.List;

public class EditProfile extends AppCompatActivity {

    EditText username,dob,password;
    Button edit,delete,search;
    RadioButton male,female;
    String gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        username =findViewById(R.id.etUserNameEP);
        dob =findViewById(R.id.etDobEP);
        password=findViewById(R.id.edPasswordEP);
        search=findViewById(R.id.btnSearch);
        male=findViewById(R.id.rbtnEP1);
        female=findViewById(R.id.rdbEP2);
        edit=findViewById(R.id.btnUpdateEP);
        delete=findViewById(R.id.btnDeleteEP);




        //Member Search

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBHandler dbHandler =new DBHandler(getApplicationContext());
                List user=dbHandler.readAllInfo(username.getText().toString());

                if(user.isEmpty()){
                    Toast.makeText(EditProfile.this, "No User", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(EditProfile.this,"User Found!User:"+user.get(0).toString(),Toast.LENGTH_SHORT).show();
                    username.setText(user.get(0).toString());
                    dob.setText(user.get(1).toString());
                    password.setText(user.get(2).toString());
                    if(user.get(3).toString().equals("Male")){
                        male.setChecked(true);
                    }
                    else{female.setChecked(true);
                    }
                }
            }
        });

        
        //Edit User
        //Delete User

    }
}