package com.gps.rahul.admin.firebasedatabasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.gps.rahul.admin.firebasedatabasedemo.Model.RegisterModel;

public class MainActivity extends AppCompatActivity {
    EditText edt_name,edt_email;
    Button btn_submit;

    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference= FirebaseDatabase.getInstance().getReference("userDetail");

        edt_name=(EditText)findViewById(R.id.edt_name);
        edt_email=(EditText)findViewById(R.id.edt_email);
        btn_submit=(Button)findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUser();
            }
        });
    }

    private void addUser() {
        String name=edt_name.getText().toString().trim();
        String email=edt_email.getText().toString().trim();
        if(name.isEmpty())
        {
            Toast.makeText(MainActivity.this, "Enter the Name", Toast.LENGTH_SHORT).show();
        }
        else if(email.isEmpty())
        {
            Toast.makeText(MainActivity.this, "Enter the Email", Toast.LENGTH_SHORT).show();
        }
        else
        {
            String id=databaseReference.push().getKey();

            RegisterModel.UserDetailBean registerModel=new RegisterModel.UserDetailBean();
            registerModel.setUser_id(id);
            registerModel.setName(name);
            registerModel.setEmail(email);

            databaseReference.child(id).setValue(registerModel);
            Toast.makeText(this, "Register Successful", Toast.LENGTH_SHORT).show();
            edt_name.setText("");
            edt_email.setText("");
        }
    }
}
