package com.parse.starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class my_details1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Button B1;
    Button B2;
    Button B3;
    RadioButton R1;
    Button B4;
    String text;

    public void submit(View view){
        B4=(Button)findViewById(R.id.b4);
        final EditText nameofPerson=(EditText)findViewById(R.id.nameofPerson);
        final EditText mobileNumber=(EditText)findViewById(R.id.phone);
        final EditText address=(EditText)findViewById(R.id.address);
        final EditText city=(EditText) findViewById(R.id.city);
        final CheckBox checkBoxBloodDonor=(CheckBox)findViewById(R.id.checkboxblooddonor);
        RadioGroup radioGroup=(RadioGroup)findViewById(R.id.radioGroup);


        int selectId=radioGroup.getCheckedRadioButtonId();
        R1=(RadioButton)findViewById(selectId);

        String username1=ParseUser.getCurrentUser().getUsername();

        ParseQuery<ParseObject> parseQuery=new ParseQuery<ParseObject>("My_Details");
        parseQuery.whereEqualTo("username",username1);
        parseQuery.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e==null){
                    if (objects.size()>0){
                        for (ParseObject object:objects){
                            object.put("nameofPerson",nameofPerson.getText().toString());
                            object.put("MobileNumber",mobileNumber.getText().toString());
                            object.put("address",address.getText().toString());
                            object.put("city",city.getText().toString());
                            object.put("Blood_Group",text);
                            if(checkBoxBloodDonor.isChecked()){
                                object.put("blood_Donate","true");
                            }else{
                                object.put("blood_Donate","false");
                            }

                            object.put("Gender",R1.getText().toString());
                            object.put("DetailsFilled","false");

                            object.saveInBackground();

                        }
                    }
                }
            }
        });

//        Log.i("Button was","tapped");
//        Intent intent=new Intent(getApplicationContext(),searchDonor.class);
//        startActivity(intent);


    }


    public void my_details(View view){
        B3=(Button)findViewById(R.id.b3);
        Log.i("Button was","tapped");
        Intent intent=new Intent(getApplicationContext(),my_details1.class);
        startActivity(intent);
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
        setContentView(R.layout.activity_my_details1);

        final EditText nameofPerson=(EditText)findViewById(R.id.nameofPerson);
        final EditText mobileNumber=(EditText)findViewById(R.id.phone);
        final EditText address=(EditText)findViewById(R.id.address);
        final EditText city=(EditText) findViewById(R.id.city);
        final CheckBox checkBoxBloodDonor=(CheckBox)findViewById(R.id.checkboxblooddonor);
        RadioGroup radioGroup=(RadioGroup)findViewById(R.id.radioGroup);

        final TextView textView1=(TextView)findViewById(R.id.T1);
        final TextView textView2=(TextView)findViewById(R.id.T2);





        int selectId=radioGroup.getCheckedRadioButtonId();
        R1=(RadioButton)findViewById(selectId);

        String username1= ParseUser.getCurrentUser().getUsername();



        ParseQuery<ParseObject> parseQuery=new ParseQuery<ParseObject>("My_Details");
        parseQuery.whereEqualTo("username",username1);

        parseQuery.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e==null){
                    if (objects.size()>0){
                        for (ParseObject object:objects){

                            String str=object.getString("nameofPerson");

                            nameofPerson.setText(str);

                            str=object.getString("MobileNumber");
                            mobileNumber.setText(str);

                            str=object.getString("address");
                            address.setText(str);

                            str=object.getString("city");
                            city.setText(str);

                            str="Gender is "+object.getString("Gender");
                            textView1.setText(str);

//                            String str1="";

//                            str1="Will you Donate Blood : "+object.getString("blood_Donate");
//                            textView2.setText(str1);


                        }
                    }
                }
            }
        });

        Spinner spinner=(Spinner)findViewById(R.id.bloodgroup_spinner);
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

