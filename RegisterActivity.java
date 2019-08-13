package com.parse.starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

public class RegisterActivity extends AppCompatActivity {

    EditText email;
    EditText username;
    EditText password;

//    @Override
//    public void onClick(View view) {
//        if (view.getId()==R.id.login){
//            Log.i("Switch","Was Tapped");
//        }
//    }

    public void login(View view){
//        Button button=(Button)findViewById(R.id.login);
//        Intent intent=new Intent(this,MainActivity.class);
        finish();

    }

    public void showUserList(){
        Intent intent=new Intent(getApplicationContext(),ListActivity.class);
        startActivity(intent);
    }

    public void show_My_Details(){
        Intent intent=new Intent(getApplicationContext(),DetailsofUser.class);
        startActivity(intent);
    }


    public void signup(View view){
        email=(EditText)findViewById(R.id.email);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);

        if (username.getText().toString().matches("")||password.getText().toString().matches("")||email.getText().toString().matches("")){
            Toast.makeText(this, "A Username and Password is required", Toast.LENGTH_SHORT).show();
        }else{
            ParseUser parseUser=new ParseUser();
            parseUser.setUsername(username.getText().toString());

            parseUser.setPassword(password.getText().toString());
            parseUser.setEmail(email.getText().toString());

            ParseObject parseObject=new ParseObject("My_Details");
            parseObject.put("DetailsFilled","false");
            parseObject.put("username",username.getText().toString());
            parseObject.put("email",email.getText().toString());
            parseObject.put("password",password.getText().toString());



            parseObject.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e==null){
                        Log.i("Message","Ho gya");
                    }else{
                        Log.i("Message","Nhi hua");
                    }
                }
            });

            parseUser.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if(e==null){
                        Log.i("Login","Success Ho gya");
                        show_My_Details();
                    }else{
                        Log.i("Nhi Hua","Rolo");
                        Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });



        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }



}
