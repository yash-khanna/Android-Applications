package com.parse.starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BloodBank extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String text;
    Button B1;
    Button B2;
    Button B3;
    Button sendRequest;
    TextView textView;
    TextView T1;
    TextView T2;
    TextView T3;
    TextView T4;
    TextView T5;
    TextView T6;
    TextView T7;
    TextView T8;
    RelativeLayout relativeLayout;
    RelativeLayout relativeLayout1;
    Spinner spinner;

    public void my_details(View view){
        B3=(Button)findViewById(R.id.b3);
        Log.i("Button was","tapped");
        Intent intent=new Intent(getApplicationContext(),my_details1.class);
        startActivity(intent);
    }


    public void sendrequest2(View view){
        sendRequest=(Button)findViewById(R.id.sendrequest1);
        relativeLayout1.animate().alpha(0f);
        relativeLayout.animate().alpha(1f);
    }

    public void textViewClicked(View view){
        textView=(TextView)findViewById(R.id.textView1);
        relativeLayout1.animate().alpha(1f);
        relativeLayout.animate().alpha(0f);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_bank);

        spinner=(Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.Blood_Groups,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        relativeLayout=(RelativeLayout)findViewById(R.id.greetings);
        relativeLayout1=(RelativeLayout)findViewById(R.id.r1);
        textView=(TextView)findViewById(R.id.textView);

        T1=(TextView)findViewById(R.id.T1);
        T2=(TextView)findViewById(R.id.T2);
        T3=(TextView)findViewById(R.id.T3);
        T4=(TextView)findViewById(R.id.T4);
        T5=(TextView)findViewById(R.id.T5);
        T6=(TextView)findViewById(R.id.T6);
        T7=(TextView)findViewById(R.id.T7);
        T8=(TextView)findViewById(R.id.T8);


        ParseQuery<ParseObject> parseQuery=new ParseQuery<ParseObject>("My_Details");
        final ArrayList<String> listOfDonors=new ArrayList<String>();
        final ArrayList<String> listOfDonors1=new ArrayList<String>();
        final ArrayList<String> listOfDonors2=new ArrayList<String>();
        final ArrayList<String> listOfDonors3=new ArrayList<String>();
        final ArrayList<String> listOfDonors4=new ArrayList<String>();
        final ArrayList<String> listOfDonors5=new ArrayList<String>();
        final ArrayList<String> listOfDonors6=new ArrayList<String>();
        final ArrayList<String> listOfDonors7=new ArrayList<String>();

        Random random=new Random();
        int a=random.nextInt(27)+3;







        parseQuery.whereEqualTo("blood_Donate","true");
        parseQuery.whereEqualTo("Blood_Group","A+");

        parseQuery.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e==null){
                    if(objects.size()>0){
                        for (ParseObject object:objects){
                            listOfDonors.add(object.getString("nameofPerson"));
                        }



                    }
                }
            }
        });

        Log.i("Length is",Integer.toString(random.nextInt(27)+3));

        String str="A+ :"+Integer.toString(random.nextInt(27)+3)+" Units";
        T1.setText(str);

        ParseQuery<ParseObject> parseQuery1=new ParseQuery<ParseObject>("My_Details");

        parseQuery1.whereEqualTo("blood_Donate","true");
        parseQuery1.whereEqualTo("Blood_Group","A-");

        parseQuery1.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e==null){
                    if(objects.size()>0){
                        for (ParseObject object:objects){
                            listOfDonors1.add(object.getString("nameofPerson"));
                        }



                    }
                }
            }
        });

        str="A- :"+Integer.toString(random.nextInt(27)+3)+" Units";
        T2.setText(str);

        ParseQuery<ParseObject> parseQuery2=new ParseQuery<ParseObject>("My_Details");


        parseQuery2.whereEqualTo("blood_Donate","true");
        parseQuery2.whereEqualTo("Blood_Group","O+");

        parseQuery2.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e==null){
                    if(objects.size()>0){
                        for (ParseObject object:objects){
                            listOfDonors2.add(object.getString("nameofPerson"));
                        }



                    }
                }
            }
        });

        str="O+ :"+Integer.toString(random.nextInt(27)+3)+" Units";
        T3.setText(str);

        ParseQuery<ParseObject> parseQuery3=new ParseQuery<ParseObject>("My_Details");


        parseQuery3.whereEqualTo("blood_Donate","true");
        parseQuery3.whereEqualTo("Blood_Group","O-");

        parseQuery3.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e==null){
                    if(objects.size()>0){
                        for (ParseObject object:objects){
                            listOfDonors3.add(object.getString("nameofPerson"));
                        }



                    }
                }
            }
        });

        str="O- :"+Integer.toString(random.nextInt(27)+3)+" Units";
        T4.setText(str);

        ParseQuery<ParseObject> parseQuery4=new ParseQuery<ParseObject>("My_Details");


        parseQuery4.whereEqualTo("blood_Donate","true");
        parseQuery4.whereEqualTo("Blood_Group","B+");

        parseQuery4.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e==null){
                    if(objects.size()>0){
                        for (ParseObject object:objects){
                            listOfDonors4.add(object.getString("nameofPerson"));
                        }



                    }
                }
            }
        });

        str="B+ :"+Integer.toString(random.nextInt(27)+3)+" Units";
        T5.setText(str);

        ParseQuery<ParseObject> parseQuery5=new ParseQuery<ParseObject>("My_Details");


        parseQuery5.whereEqualTo("blood_Donate","true");
        parseQuery5.whereEqualTo("Blood_Group","B-");

        parseQuery5.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e==null){
                    if(objects.size()>0){
                        for (ParseObject object:objects){
                            listOfDonors5.add(object.getString("nameofPerson"));
                        }



                    }
                }
            }
        });

        str="B- :"+Integer.toString(random.nextInt(27)+3)+" Units";
        T6.setText(str);

        ParseQuery<ParseObject> parseQuery6=new ParseQuery<ParseObject>("My_Details");


        parseQuery6.whereEqualTo("blood_Donate","true");
        parseQuery6.whereEqualTo("Blood_Group","AB+");

        parseQuery6.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e==null){
                    if(objects.size()>0){
                        for (ParseObject object:objects){
                            listOfDonors6.add(object.getString("nameofPerson"));
                        }



                    }
                }
            }
        });

        str="AB+ :"+Integer.toString(random.nextInt(27)+3)+" Units";
        T7.setText(str);

        ParseQuery<ParseObject> parseQuery8=new ParseQuery<ParseObject>("My_Details");


        parseQuery8.whereEqualTo("blood_Donate","true");
        parseQuery8.whereEqualTo("Blood_Group","AB-");

        parseQuery8.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e==null){
                    if(objects.size()>0){
                        for (ParseObject object:objects){
                            listOfDonors7.add(object.getString("nameofPerson"));
                        }



                    }
                }
            }
        });

        str="AB- :"+Integer.toString(random.nextInt(27)+3)+" Units";
        T8.setText(str);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        text=text=adapterView.getItemAtPosition(i).toString();
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
