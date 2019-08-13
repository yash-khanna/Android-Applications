package com.parse.starter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    Boolean DetailsFilled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        final ListView listView=(ListView)findViewById(R.id.listView);
        final ArrayList<String> usernames=new ArrayList<String>();
        final ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,usernames);

        ParseQuery<ParseUser> query=ParseUser.getQuery();

//        query.whereNotEqualTo("username",ParseUser.getCurrentUser().getUsername());
        query.addAscendingOrder("username");

        query.findInBackground(new FindCallback<ParseUser>() {
            @Override
            public void done(List<ParseUser> objects, ParseException e) {
                if(e==null){
                    if(objects.size()>0){
                        for (ParseUser user:objects){
                            usernames.add(user.getUsername());
                        }
                        listView.setAdapter(arrayAdapter);

                    }
                }else{

                }
            }
        });

//        ParseObject parseObject=new ParseObject("My_Details");
//        parseObject.put("nameofPerson","vaibhav");
//        parseObject.put("gender","male");
//        parseObject.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//                if (e==null){
//                    Log.i("Message","Ho gya");
//                }else{
//                    Log.i("Message","Nhi hua");
//                }
//            }
//        });

        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }
}
