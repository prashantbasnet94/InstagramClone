package com.parse.starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class SignIn extends AppCompatActivity {
EditText userid,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    public void signUp(View view){
        Intent signaUp=new Intent(this,SignUp.class);
        startActivity(signaUp);
    }

    public void login(View view){


        userid=(EditText) findViewById(R.id.userId);
        password=(EditText) findViewById(R.id.password);
        ParseUser user=new ParseUser();
        ParseUser.logInInBackground(userid.getText().toString(), password.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e==null){
                    Intent home=new Intent(getApplicationContext(),Home.class);
                    startActivity(home);
                }else{
                    e.printStackTrace();
                }
            }
        });

    }


}
