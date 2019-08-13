/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.TextView;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;


import java.util.List;


public class MainActivity extends AppCompatActivity {

  RelativeLayout R1,RL1;
  TextView I1;

  public void showUserList(){
    Intent intent=new Intent(getApplicationContext(),ListActivity.class);
    startActivity(intent);
  }

  public void searchDonor(){
    Intent intent=new Intent(getApplicationContext(),searchDonor.class);
    startActivity(intent);
  }

  public void animate(View view){
    ImageView I1=(ImageView)findViewById(R.id.b1);

    GridLayout GL1=(GridLayout)findViewById(R.id.GL1);
    I1.animate().alpha(0f).setDuration(1250);
//    startActivity(new Intent(getApplicationContext(),LoginActivity.class));
    RL1.setVisibility(View.VISIBLE);
    GL1.setVisibility(View.VISIBLE);
  }

  public void login(View view) {
    Button B1=(Button)findViewById(R.id.button2);
    EditText username=(EditText)findViewById(R.id.l2);
    EditText password=(EditText)findViewById(R.id.l3);

//    ParseUser parseUser=new ParseUser();
    ParseUser.logInInBackground(username.getText().toString(), password.getText().toString(), new LogInCallback() {
      @Override
      public void done(ParseUser user, ParseException e) {
        if (user!=null){
          Log.i("Login","Ok");
          searchDonor();
        }else{
          Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
      }
    });

  }

  public void register(View view) {
    Button B2=(Button)findViewById(R.id.button3);
    Intent intent=new Intent(this,RegisterActivity.class);
    startActivity(intent);
  }


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    R1=(RelativeLayout)findViewById(R.id.R1);
    I1=(TextView) findViewById(R.id.l1);
    RL1=(RelativeLayout)findViewById(R.id.RL1);
//    RL1.setOnClickListener(this);
//    I1.setOnClickListener(this);

    if (ParseUser.getCurrentUser()!=null){
        showUserList();
    }

//    ParseObject score=new ParseObject("Score");
//    score.put("Username","vaibhav");
//    score.put("Score","3");
//    score.saveInBackground(new SaveCallback() {
//      @Override
//      public void done(ParseException e) {
//        if (e==null){
//          Log.i("Hello","Ho gya ");
//        }else{
//          Log.i("Hello","Nhi hua rolo");
//        }InBackground();
//         Log.i("Username",object.getString("Username"));
//         Log.i("Sco
//      }
//    });

//    ParseQuery<ParseObject> query=new ParseQuery<ParseObject>("Score");
//
//    query.getInBackground("1BqaADWHG9", new GetCallback<ParseObject>() {
//      @Override
//      public void done(ParseObject object, ParseException e) {
//       if (e==null && object!=null){
//         object.put("Score","10");
//         object.savere",object.getString("Score"));
//       }
//      }
//    });

//    final ParseObject parseObject=new ParseObject("Tweet");
//    parseObject.put("Username","vaibhav");
//    parseObject.put("Password","vaibhav123");
//    parseObject.saveEventually(new SaveCallback() {
//      @Override
//      public void done(ParseException e) {
//        if (e==null){
////          Log.i("Username",parseObject.getString("Username"));
//          Log.i("Hello","Yes ho gya");
//          }else{
//          Log.i("Hi","Nhi Hua");
//
//        }
//      }
//    });

//    ParseQuery<ParseObject> query=new ParseQuery<ParseObject>("Tweet");
//    query.getInBackground("dHZjC2nNjK", new GetCallback<ParseObject>() {
//      @Override
//      public void done(ParseObject object, ParseException e) {
//
//        object.put("Password","Vaibhav345");
//        object.saveInBackground();
//
//        if (e==null && object!=null){
//          Log.i("Username",object.getString("Username"));
//          Log.i("Password",object.getString("Password"));
//        }
//      }
//    });

//    ParseObject parseObject=new ParseObject("Points");
//    parseObject.put("Student","Yash Khanna");
//    parseObject.put("Points",45);
//    parseObject.saveEventually(new SaveCallback() {
//      @Override
//      public void done(ParseException e) {
//        if (e==null){
//          Log.i("Hello","Ho gya");
//        }else{
//          Log.i("Hello","Nhi Hua");        }
//      }
//    });

//    ParseQuery<ParseObject> query=ParseQuery.getQuery("Marks");
//    query.whereGreaterThan("Marks",24);
//    query.setLimit(3);
//
//    query.findInBackground(new FindCallback<ParseObject>() {
//      @Override
//      public void done(List<ParseObject> objects, ParseException e) {
//        if (e==null){
//          if (objects.size()>0){
//            for (ParseObject object :objects){
//              Log.i("Student",object.getString("Student"));
//
//              Log.i("Marks",Integer.toString(object.getInt("Marks")));
//            }
//          }
//        }
//      }
//    });

//      ParseQuery<ParseObject> query=ParseQuery.getQuery("Points");
//
////      ParseObject parseObject=Parse
//
//      query.whereGreaterThan("Points",50);
//
//      query.findInBackground(new FindCallback<ParseObject>() {
//          @Override
//          public void done(List<ParseObject> objects, ParseException e) {
//              if(e==null){
//                  if (objects.size()>0){
//                      for (ParseObject object:objects){
//                          object.put("Points",object.getInt("Points") + 20);
//                          object.saveInBackground();
//
//                      }
//                  }
//              }
//          }
//      });

//      ParseUser parseUser=new ParseUser();
//      parseUser.setUsername("yash khanna");
//      parseUser.setPassword("yashi345");
//
//      parseUser.signUpInBackground(new SignUpCallback() {
//          @Override
//          public void done(ParseException e) {
//              if (e==null){
//                  Log.i("Ho Gya","Ho gya");
//
//              }else{
//                  Log.i("Nhi Hua","Nhi Hua");
//              }
//          }
//      });

//      ParseUser parseUser=new ParseUser();
      // code that created khanna
//      ParseObject parseObject=new ParseObject("Khanna");
//      parseObject.put("username","vaibhav");
//      parseObject.put("password","yashi345");
//      parseObject.saveInBackground(new SaveCallback() {
//          @Override
//          public void done(ParseException e) {
//              if (e==null){
//                  Log.i("Message","Ho gya");
//              }else{
//                  Log.i("Message","Nhi hua");
//              }
//          }
//      });

//      ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("Khanna");
//      parseQuery.getInBackground("VtuNQPcyvy", new GetCallback<ParseObject>() {
//          @Override
//          public void done(ParseObject object, ParseException e) {
//              if (e==null){
//                  object.put("username","Dadu");
//                  object.put("password","yashi345");
//                  object.saveInBackground();
//                  Log.i("username",object.getString("username"));
//                  Log.i("Password",object.getString("password"));
//
//              }else{
//
//                  Log.i("Failed","failed");
//
//              }
//          }
//      });



    ParseAnalytics.trackAppOpenedInBackground(getIntent());
  }



}
