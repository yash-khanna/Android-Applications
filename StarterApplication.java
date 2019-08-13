/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;

import android.app.Application;
import android.util.Log;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;


public class StarterApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    // rJQTLA4lFREq

    // Enable Local Datastore.
    Parse.enableLocalDatastore(this);

    // Add your initialization code here
    Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
            .applicationId("5990c8ad4c520bdd9b55a78368a8576ad6f9b427")
            .clientKey("ecb36fba854a844d10a9943d0b7522209b378ece")
            .server("http://3.14.153.74:80/parse/")
            .build()
    );

    ParseObject object = new ParseObject("ExampleObject");
    object.put("myNumber", "123");
    object.put("myString", "rob");

    object.saveInBackground(new SaveCallback () {
      @Override
      public void done(ParseException ex) {
        if (ex == null) {
          Log.i("Parse Result", "Successful!");
        } else {
          Log.i("Parse Result", "Failed" + ex.toString());
        }
      }
    });

    ParseUser parseUser=new ParseUser();



//    ParseUser parseUser=new ParseUser();
//    parseUser.setUsername("yash");
//    parseUser.setPassword("khanna");
//
//    parseUser.signUpInBackground(new SignUpCallback() {
//        @Override
//        public void done(ParseException e) {
//            if (e==null){
//                Log.i("Sign Up CallBack","We did it");
//            }else{
//                e.printStackTrace();
//            }
//        }
//    });

//      ParseUser.logInInBackground("yash", "khanna1", new LogInCallback() {
//          @Override
//          public void done(ParseUser user, ParseException e) {
//              if (user!=null){
//                  Log.i("Success","We logged In");
//              }else{
//                  e.printStackTrace();
//              }
//          }
//      });
      ParseUser.logOut();

      if (ParseUser.getCurrentUser()!=null){
          Log.i("Signed In","We are In");
      }else{
          Log.i("Not Signed In","No we are not");
      }



    ParseACL defaultACL = new ParseACL();
    defaultACL.setPublicReadAccess(true);
    defaultACL.setPublicWriteAccess(true);
    ParseACL.setDefaultACL(defaultACL, true);

  }
}
