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

public class DriverRegistration extends AppCompatActivity implements  AdapterView.OnItemSelectedListener, DatePickerDialog.OnDateSetListener {

    EditText drivername,fathername,presentaddress,permanentaddress,mobileno,joblocation,referencno,drivinglicence,nationalid,username,password,carexperience,expectedsalary;
    Button birthday,driver_sign;
    private static final String driverregisterurl="http://sd.smrobi.com/api/DriverRegApi.php";
    String[] religion={"Select here","islam","hindu","Others"};
    String[] education1={"Select here","Class Eight","SSC","HSC","Others"};
    String[] preference={"Select here","Uber","Personal","Personal & Uber","Company","Rent a Car","Contact a Car","Any job"};
    String[] experience={"Select here","1 Year","2 Years","3 Years","4 Years","5 Years","6 Years","7 Years","8 Years","9 Years","10 Years","12 Years","14 Years","16 Years","18 Years","20 Years","More than 25 Years"};
    String[] experiencetype={"Select here","Auto Only","Manual Only","Both"};
    String[] status={"Select here","Registred","Ready to Join","Working"};
    public Spinner jobpreference,education,spinner_status,spinner_religion,spinner_experience,Spinner_experiencetype;

    String _religion,_education,_experience,_experiencetype,_status;
    String date,Drivername,Fathername,Presentaddress,Parmanentaddress,Mobileno,Joblocation,Referencenumber,Drivinglicence,Nationalid,Carexperience,Expectedsalary,Password,Username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_registration);



        drivername=findViewById(R.id.drivername2);
        fathername=findViewById(R.id.fathername2);
        presentaddress=findViewById(R.id.presentaddress2);
        permanentaddress=findViewById(R.id.parmanentaddress2);
        mobileno=findViewById(R.id.mobileno2);



        spinner_religion=findViewById(R.id.spinner_religion2);
        spinner_religion.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter aa7 = new ArrayAdapter(DriverRegistration.this,android.R.layout.simple_spinner_item, religion);
        aa7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
        spinner_religion.setAdapter(aa7);

        education=findViewById(R.id.spinner_education2);
        education.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter aa3 = new ArrayAdapter(DriverRegistration.this,android.R.layout.simple_spinner_item, education1);
        aa3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
        education.setAdapter(aa3);


        joblocation=findViewById(R.id.joblocations2);
        referencno=findViewById(R.id.referencenumber2);
        drivinglicence=findViewById(R.id.drivinglicence2);
        nationalid=findViewById(R.id.nationalid2);





        birthday=findViewById(R.id.birthday2);
        birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment1=new DatePickerFragment();
                dialogFragment1.show(getSupportFragmentManager(),"date picker");
                //Toast.makeText(Main2Activity.this,"date:"+date,Toast.LENGTH_LONG).show();
            }
        });

        spinner_experience=findViewById(R.id.spinner_experience2);
        spinner_experience.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter aa4 = new ArrayAdapter(DriverRegistration.this,android.R.layout.simple_spinner_item, experience);
        aa4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_experience.setAdapter(aa4);


        Spinner_experiencetype=findViewById(R.id.experiencetype2);
        Spinner_experiencetype.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter aa5 = new ArrayAdapter(DriverRegistration.this,android.R.layout.simple_spinner_item, experiencetype);
        aa5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner_experiencetype.setAdapter(aa5);


        carexperience=findViewById(R.id.carexperience2);
        expectedsalary=findViewById(R.id.expectedsalary2);



        spinner_status=findViewById(R.id.spinner_status2);
        spinner_status.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter aa6 = new ArrayAdapter(DriverRegistration.this,android.R.layout.simple_spinner_item,status);
        aa6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_status.setAdapter(aa6);


        password=findViewById(R.id.password2);
        username=findViewById(R.id.username2);









        driver_sign=findViewById(R.id.driversign_up);
        driver_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerProcess();
            }
        });
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        switch (parent.getId()) {
            case R.id.spinner_religion2:
                _religion = spinner_religion.getSelectedItem().toString();
                // Toast.makeText(Main2Activity.this, "Selected Prefession:" + _jobpreference, Toast.LENGTH_LONG).show();
                break;
            case R.id.spinner_education2:
                _education = education.getSelectedItem().toString();
            case R.id.spinner_experience2:
                _experience = spinner_experience.getSelectedItem().toString();
            case R.id.experiencetype2:
                _experience = Spinner_experiencetype.getSelectedItem().toString();
            case R.id.spinner_status2:
                _status = spinner_status.getSelectedItem().toString();

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    private   void registerProcess() {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, driverregisterurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            String result=jsonObject.getString("result");
                            if(result.equals("Success")){

                                Toast.makeText(DriverRegistration.this,"You registered"+result,Toast.LENGTH_LONG).show();
                            }
                            else{


                                Toast.makeText(DriverRegistration.this,"Error Occured"+result,Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(DriverRegistration.this,"Error Occured"+error.toString(),Toast.LENGTH_LONG).show();

            }
        })
        {
            @Override
            public byte[] getBody() throws AuthFailureError {

                Drivername=drivername.getText().toString();
                Fathername=fathername.getText().toString();
                Presentaddress=presentaddress.getText().toString();
                Parmanentaddress=permanentaddress.getText().toString();
                Mobileno=mobileno.getText().toString();

                Joblocation=joblocation.getText().toString();
                Referencenumber=referencno.getText().toString();
                Drivinglicence=drivinglicence.getText().toString();
                Nationalid=nationalid.getText().toString();

                Carexperience=carexperience.getText().toString();
                Expectedsalary=expectedsalary.getText().toString();

                Password=password.getText().toString();
                Username=username.getText().toString();


                JSONObject params = new JSONObject();
                try {
                    params.put("id",4+"");
                    params.put("driverName",Drivername);
                    params.put("fatherName",Fathername);
                    params.put("presentAddress",Presentaddress);
                    params.put("permanentAddress",Parmanentaddress);
                    params.put("driverMobile ",Mobileno);
                    params.put("religion",_religion);
                    params.put("education",_education);
                    params.put("jobLocation",Joblocation);
                    params.put("refNumber",Referencenumber);
                    params.put("dlNumber",Drivinglicence);
                    params.put("nidNumber",Nationalid);
                    params.put("dateBirth",date);
                    params.put("expYear",_experience);
                    params.put("expType",_experiencetype);
                    params.put("expCar",Carexperience);
                    params.put("expSalary",Expectedsalary);
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

        RequestQueue requestQueue= Volley.newRequestQueue(DriverRegistration.this);
        requestQueue.add(stringRequest);
    }
}
