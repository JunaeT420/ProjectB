package com.example.user.projectb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView link_signup;
    EditText user_name,user_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        link_signup= (TextView) findViewById(R.id.link_signup);
        user_name= (EditText) findViewById(R.id.user_name);
       user_password= (EditText) findViewById(R.id.password);
        link_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,SignUp.class);
                startActivity(i);
            }
        });
    }


    public void login(View view){
        String username=user_name.getText().toString();
        String passwordb=user_password.getText().toString();
        if (username.equals("")||passwordb.equals("")){
           user_name.setError("valid user name");
            user_password.setError("valid password");
        }else {
              Toast.makeText(getApplicationContext(),"Success...",Toast.LENGTH_SHORT).show();
        Intent i=new Intent(MainActivity.this,Mapdemo.class);
        startActivity(i);
        }

    }
}
