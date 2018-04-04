package com.parse.starter;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

public class SignUp extends AppCompatActivity {

    EditText firstName, lastName, userId, email, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity);



    }

    public void save(View view) {
        EditText firstName = (EditText) findViewById(R.id.firstName);
        EditText lastName = (EditText) findViewById(R.id.lastName);
        EditText userId = (EditText) findViewById(R.id.userId);
        EditText email = (EditText) findViewById(R.id.email);
        EditText password = (EditText) findViewById(R.id.password);

        ParseObject parseObject;
        parseObject = new ParseObject("User");
    //    if (firstName.getText().toString() && lastName.getText().toString() && email.getText().toString() && userId.getText().toString()&& password.getText().toString() != null) {

      Log.i("firstName",firstName.getText().toString());
        Log.i("lastName",lastName.getText().toString());
        Log.i("userId",userId.getText().toString());
        Log.i("email",email.getText().toString());

        ParseUser user =new ParseUser();
        user.setUsername(userId.getText().toString());
        user.setPassword(password.getText().toString());
        user.setEmail(email.getText().toString());

           user.put("firstName", firstName.getText().toString());
            user.put("lastName", lastName.getText().toString());



          user.signUpInBackground(new SignUpCallback() {
              @Override
              public void done(ParseException e) {
                  if(e==null){
                      Log.i("Status","Done");
                      finish();
                  }else{
                      e.printStackTrace();
                  }
              }
          });
      /*  }else {
            Toast.makeText(this, "check  your field value properly!!", Toast.LENGTH_SHORT).show();
        }   */

    }




}
