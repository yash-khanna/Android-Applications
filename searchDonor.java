package com.parse.starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class searchDonor extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String text;
    Button B1;
    Button B2;
    Button B3;
    Button B4;
    Button contact1;
    TextView textView;
    RelativeLayout relativeLayout;
    RelativeLayout relativeLayout1;



    public void contact(View view){
        contact1=(Button)findViewById(R.id.sendrequest);
        final ListView listView=(ListView)findViewById(R.id.listView);
        final ArrayList<String> listOfDonors=new ArrayList<String>();
        final ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listOfDonors);

        final ParseQuery<ParseObject> parseQuery=new ParseQuery<ParseObject>("My_Details");

        parseQuery.whereEqualTo("blood_Donate","true");
        parseQuery.whereEqualTo("Blood_Group",text);
        parseQuery.addAscendingOrder("nameofPerson");

        parseQuery.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e==null){
                    if(objects.size()>0){
                        for (ParseObject object:objects){
                            listOfDonors.add(object.getString("nameofPerson"));
                        }
                        listView.setAdapter(arrayAdapter);

                    }
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ParseQuery<ParseObject> parseQuery1=new ParseQuery<ParseObject>("My_Details");
                Log.i("input ",listOfDonors.get(i));
                parseQuery1.whereEqualTo("nameofPerson",listOfDonors.get(i));
                parseQuery1.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> objects, ParseException e) {
                        if(e==null){
                            if(objects.size()>0){
                                for (ParseObject object:objects){
                                    String str="Name of User is "+object.getString("nameofPerson");
                                    str+=" Email is "+object.getString("email");
                                    str+=" MobileNumber is"+object.getString("MobileNumber");
                                    str+="Address is "+object.getString("address");
                                    str+="City is "+object.getString("city");
//                                    Log.i("Name of User is ",object.getString("nameofPerson"));
//                                    Log.i("Email is ",object.getString("email"));
//                                    Log.i("MobileNumber is",object.getString("MobileNumber"));
//                                    Log.i("Address is ",object.getString("address"));
//                                    Log.i("City is ",object.getString("city"));
                                    textView.setText(str);
                                    relativeLayout1.animate().alpha(0);
                                    relativeLayout.animate().alpha(1);

                                }
                            }
                        }
                    }
                });
            }
        });
    }

    public void searchDonor(View view){
        B1=(Button)findViewById(R.id.b1);
        Log.i("Button was","tapped");
        Intent intent=new Intent(getApplicationContext(),searchDonor.class);
        startActivity(intent);
    }

    public void bloodBank(View view){
        B2=(Button)findViewById(R.id.b2);
        Log.i("Button was","tapped");
        Intent intent=new Intent(getApplicationContext(),BloodBank.class);
        startActivity(intent);
    }

    public void textViewClicked(View view){
        textView=(TextView)findViewById(R.id.textView);
        relativeLayout1.animate().alpha(1f);
        relativeLayout.animate().alpha(0f);
    }

    public void MyDetails(View view){
        B3=(Button)findViewById(R.id.b3);
        Log.i("Button was","tapped");
        Intent intent=new Intent(getApplicationContext(),my_details1.class);
        startActivity(intent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_donor);
        String username1= ParseUser.getCurrentUser().getUsername();
        relativeLayout=(RelativeLayout)findViewById(R.id.greetings);
        relativeLayout1=(RelativeLayout)findViewById(R.id.greetings1);
        textView=(TextView)findViewById(R.id.textView);

        relativeLayout1.animate().alpha(1f).setDuration(4500);
        relativeLayout.animate().alpha(0f).setDuration(3500);

        Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();

        Spinner spinner=(Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.Blood_Groups,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);






    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        text=adapterView.getItemAtPosition(i).toString();
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
