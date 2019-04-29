package com.appinventor.ai_Robi_buet38.SMARTDRIVERBD;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class OwnerRegistration extends AppCompatActivity implements AdapterView.OnItemSelectedListener, DatePickerDialog.OnDateSetListener {

    public  String Carownername,PresentAddress,EmailAddress,ProfessionDetails,ProfessionAddress,JobLocation,CarName,Password,Username;
    String MobileNo;
    String OfferSalary;
    String WorkingHours;
    private static final String registerrequesturl="http://sd.smrobi.com/api/OwnerRegApi.php";
    String[] religion={"Select here","islam","hindu","Others"};
    String[] education1={"Select here","Class Eight","SSC","HSC","Others"};
    String[] preference={"Select here","Uber","Personal","Personal & Uber","Company","Rent a Car","Contact a Car","Any job"};
    String[] experience={"Select here","1 Year","2 Years","3 Years","4 Years","5 Years","6 Years","7 Years","8 Years","9 Years","10 Years","12 Years","14 Years","16 Years","18 Years","20 Years","More than 25 Years"};
    String[] profession={"Select here","Doctor","Engineer"," Businessman","Politician","Teacher","Gov Officer"};
    String[] status={"Select here","Registred","Ready to Join","Working"};
    String[] accomadation={"Select here","Yes","No"};
    String[] lunch1={"Select here","Food","Money","Na"};
    EditText carownername,presentaddress,mobilnoo,emailaddress,professiondetails,professionaddress,joblocation,carname,offersalary,password,workinghours,username;
    public Spinner spinner_profession,jobpreference,education,acomodation,lunch,spinner_status,spinner_religion,spinner_experience;

    Button birth_day,register;
    String _profession,_jobpreference,_education,_aacomodation,_experience,_lunch,_status,_religion,date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_registration);

        register=findViewById(R.id.sign_up);
        initializeAll();




        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registerProcess();
            }
        });
    }

    private void initializeAll() {

        carownername=findViewById(R.id.carowner);


        presentaddress=findViewById(R.id.presentaddress);


        mobilnoo=findViewById(R.id.mobilno);



        emailaddress=findViewById(R.id.emailaddress);

        spinner_profession=findViewById(R.id.spinner_Profession);
        spinner_profession.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter aa1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,profession);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_profession.setAdapter(aa1);

        professiondetails=findViewById(R.id.professiondetails);



        jobpreference=findViewById(R.id.spinner_jobpreference);
        jobpreference.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter aa2 = new ArrayAdapter(OwnerRegistration.this,android.R.layout.simple_spinner_item, preference);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jobpreference.setAdapter(aa2);

        professionaddress=findViewById(R.id.professionaddress);


        joblocation=findViewById(R.id.joblocation);
        carname=findViewById(R.id.cardetails);
        offersalary=findViewById(R.id.offersalary);


        education=findViewById(R.id.spinner_education);
        education.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter aa3 = new ArrayAdapter(OwnerRegistration.this,android.R.layout.simple_spinner_item, education1);
        aa3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
        education.setAdapter(aa3);


        acomodation=findViewById(R.id.spinner_acomodation);
        acomodation.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter aa4 = new ArrayAdapter(OwnerRegistration.this,android.R.layout.simple_spinner_item, accomadation);
        aa4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
        acomodation.setAdapter(aa4);


        lunch=findViewById(R.id.spinner_lunch);
        lunch.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter aa5 = new ArrayAdapter(OwnerRegistration.this,android.R.layout.simple_spinner_item, lunch1);
        aa5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
        lunch.setAdapter(aa5);

        spinner_status=findViewById(R.id.spinner_status);
        spinner_status.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter aa6 = new ArrayAdapter(OwnerRegistration.this,android.R.layout.simple_spinner_item, status);
        aa6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
        spinner_status.setAdapter(aa6);


        password=findViewById(R.id.password);




        spinner_religion=findViewById(R.id.spinner_religion);
        spinner_religion.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter aa7 = new ArrayAdapter(OwnerRegistration.this,android.R.layout.simple_spinner_item, religion);
        aa7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
        spinner_religion.setAdapter(aa7);

        birth_day=findViewById(R.id.button_date);
        birth_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogFragment dialogFragment=new DatePickerFragment();
                dialogFragment.show(getSupportFragmentManager(),"date picker");
                //Toast.makeText(Main2Activity.this,"date:"+date,Toast.LENGTH_LONG).show();

            }
        });




        spinner_experience=findViewById(R.id.spinner_experience);
        spinner_experience.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter aa8 = new ArrayAdapter(OwnerRegistration.this,android.R.layout.simple_spinner_item, experience);
        aa8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
        spinner_experience.setAdapter(aa8);


        workinghours=findViewById(R.id.workinghour);



        username=findViewById(R.id.username);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {




        switch (parent.getId()) {
            case R.id.spinner_Profession:
                _profession = spinner_profession.getSelectedItem().toString();
               // Toast.makeText(OwnerRegistration.this, "Selected Prefession:" + _profession, Toast.LENGTH_LONG).show();
                break;
            case R.id.spinner_jobpreference:
                _jobpreference = jobpreference.getSelectedItem().toString();
              //  Toast.makeText(OwnerRegistration.this, "Selected Prefession:" + _jobpreference, Toast.LENGTH_LONG).show();
                //Your Another Action Here.
                break;
            case R.id.spinner_education:
                _education = education.getSelectedItem().toString();
               // Toast.makeText(OwnerRegistration.this, "Selected Prefession:" +_education , Toast.LENGTH_LONG).show();
                //Your Another Action Here.
                break;
            case R.id.spinner_acomodation:
                _aacomodation = acomodation.getSelectedItem().toString();
                //Your Another Action Here.
                break;
            case R.id.spinner_experience:
                _experience = spinner_experience.getSelectedItem().toString();
                //Your Another Action Here.
                break;
            case R.id.spinner_lunch:
                _lunch = lunch.getSelectedItem().toString();
                //Your Another Action Here.
                break;
            case R.id.spinner_status:
                _status = spinner_status.getSelectedItem().toString();
                //Your Another Action Here.
                break;
            case R.id.spinner_religion:
                _religion = spinner_religion.getSelectedItem().toString();
                //Your Another Action Here.
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @SuppressLint("WrongConstant")
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        java.util.Calendar calendar= java.util.Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);
        calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        date= df.format(calendar.getTime());
        Toast.makeText(this, ""+date, Toast.LENGTH_SHORT).show();
    }

    private   void registerProcess() {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, registerrequesturl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            String result=jsonObject.getString("result");
                            if(result.equals("Success")){

                                Toast.makeText(OwnerRegistration.this,"You registered"+result,Toast.LENGTH_LONG).show();
                            }
                            else{


                                Toast.makeText(OwnerRegistration.this,"Error Occured"+result,Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(OwnerRegistration.this,"Error Occured"+error.toString(),Toast.LENGTH_LONG).show();

            }
        })
        {
            @Override
            public byte[] getBody() throws AuthFailureError {

                Carownername=carownername.getText().toString();
                PresentAddress=presentaddress.getText().toString();
                MobileNo= mobilnoo.getText().toString();
                EmailAddress=emailaddress.getText().toString();
                ProfessionDetails=professiondetails.getText().toString();
                ProfessionAddress=professionaddress.getText().toString();
                JobLocation=joblocation.getText().toString();
                CarName=carname.getText().toString();
                OfferSalary=offersalary.getText().toString();
                Password=password.getText().toString();
                WorkingHours= workinghours.getText().toString();
                Username=username.getText().toString();

                JSONObject params = new JSONObject();
                try {
                    params.put("id",4+"");
                    params.put("ownerName",Carownername);
                    params.put("presentAddress",PresentAddress);
                    params.put("ownerMobile",MobileNo);
                    params.put("ownerEmail",EmailAddress);
                    params.put("religion",_religion);
                    params.put("professsion",_profession);
                    params.put("professsionDetails",ProfessionDetails);
                    params.put("professsionAddress",ProfessionAddress);
                    params.put("jobPreference",_jobpreference);
                    params.put("jobLocation",JobLocation);
                    params.put("carName",CarName);
                    params.put("startDate",date);
                    params.put("offerSalary",OfferSalary);
                    params.put("education",_education);
                    params.put("expYear",_experience);
                    params.put("accomodation",_aacomodation);
                    params.put("workingHours",WorkingHours);
                    params.put("lunch",_lunch);
                    params.put("status",_status);
                    params.put("password",Password);
                    params.put("userName",Username+System.currentTimeMillis());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return params.toString().getBytes();
            }

            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

        };

        RequestQueue requestQueue= Volley.newRequestQueue(OwnerRegistration.this);
        requestQueue.add(stringRequest);
    }
}
