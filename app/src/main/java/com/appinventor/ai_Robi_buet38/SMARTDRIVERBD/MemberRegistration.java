package com.appinventor.ai_Robi_buet38.SMARTDRIVERBD;

import android.app.DatePickerDialog;
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
import java.util.Calendar;

public class MemberRegistration extends AppCompatActivity implements AdapterView.OnItemSelectedListener, DatePickerDialog.OnDateSetListener {

    String[] mprofession={"Select here","Doctor","Engineer"," Businessman","Politician","Teacher","Gov Officer"};

    String[] collegesubject={"Select here","Science","Arts","Commerce"};
    String[] membertype={"Select here","Adviser","Member"};
    String[] paymenttype={"Select here","Free","Paid"};

    EditText membername,mfathernames,mpresentaddress,mpermanentaddress,memail,mblood,mmemberpost,mcollegename,mcollegeyear,mgraduationfrom,graduationyear,mgraduationsubject
            , postgradfrom,postgradeyear,postgrdesubject,mcompanyname,mprofessionaladdress,mmobile,mnationalid,mreferencenumber,musernames;

    Spinner memberprofession,collegsubject,typemember,typepayment;

    Button birth_day,mregister,birthday;
    String mdate,memberprofessions,msubject,membertypes,payment;

    private static final String mregisterrequesturl="http://sd.smrobi.com/api/memberRegApi.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_registration);



        membername=findViewById(R.id.mname);
        mfathernames=findViewById(R.id.mfathername);
        mpresentaddress=findViewById(R.id.mpresentaddress);
        mpermanentaddress=findViewById(R.id.mparmanentaddress);
        memail=findViewById(R.id.memailaddress);


        birthday=findViewById(R.id.mbutton_date);
        birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragmentm=new DatePickerFragment();
                dialogFragmentm.show(getSupportFragmentManager(),"date picker");
                //Toast.makeText(Main2Activity.this,"date:"+date,Toast.LENGTH_LONG).show();
            }
        });


        mblood=findViewById(R.id.mblooodgroup);

        memberprofession=findViewById(R.id.mspinner_Profession);
        memberprofession.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter a1 = new ArrayAdapter(MemberRegistration.this,android.R.layout.simple_spinner_item, mprofession);
        a1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
        memberprofession.setAdapter(a1);

        mmemberpost=findViewById(R.id.mpost);
        mcollegename=findViewById(R.id.mcollegename);
        mcollegeyear=findViewById(R.id.mcollegeyear);

        collegsubject=findViewById(R.id.mcollegesubject);
        collegsubject.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter a2 = new ArrayAdapter(MemberRegistration.this,android.R.layout.simple_spinner_item, collegesubject);
        a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
        collegsubject.setAdapter(a2);

        mgraduationfrom=findViewById(R.id.mgrgaduationfrom);
        graduationyear=findViewById(R.id.mgraduationyear);
        mgraduationsubject=findViewById(R.id.mgraduationsubject);

        postgradfrom=findViewById(R.id.mpostgradfrom);
        postgradeyear=findViewById(R.id.mpostgradyear);
        postgrdesubject=findViewById(R.id.mpostgrasubject);


        mcompanyname=findViewById(R.id.mcompanyname);
        mprofessionaladdress=findViewById(R.id.mprofessionaladdress);
        mmobile=findViewById(R.id.mmobileno);

        mnationalid=findViewById(R.id.mnationalid);
        mreferencenumber=findViewById(R.id.mrefernumber);


        typemember=findViewById(R.id.mmembertype);
        typemember.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter a3 = new ArrayAdapter(MemberRegistration.this,android.R.layout.simple_spinner_item, membertype);
        a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
        typemember.setAdapter(a3);

        typepayment=findViewById(R.id.mpaymenttype);
        typepayment.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter a4 = new ArrayAdapter(MemberRegistration.this,android.R.layout.simple_spinner_item, paymenttype);
        a4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
        typepayment.setAdapter(a4);


        musernames=findViewById(R.id.musername);





        mregister=findViewById(R.id.msign_up);
        mregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                registerProcess();
            }
        });
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {


        java.util.Calendar calendar= java.util.Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);
        calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        mdate= df.format(calendar.getTime());
        Toast.makeText(this, ""+mdate, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (parent.getId()) {
            case R.id.mspinner_Profession:
                memberprofessions = memberprofession.getSelectedItem().toString();
                // Toast.makeText(Main2Activity.this, "Selected Prefession:" + _jobpreference, Toast.LENGTH_LONG).show();
                break;
            case R.id.mcollegesubject:
                msubject= collegsubject.getSelectedItem().toString();
            case R.id.mmembertype:
                membertypes = typemember.getSelectedItem().toString();
            case R.id.mpaymenttype:
                payment = typepayment.getSelectedItem().toString();


        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private   void registerProcess() {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, mregisterrequesturl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            String result=jsonObject.getString("result");
                            if(result.equals("Success")){

                                Toast.makeText(MemberRegistration.this,"You registered Successfully"+result,Toast.LENGTH_LONG).show();
                            }
                            else{


                                Toast.makeText(MemberRegistration.this,"Error Occured"+result,Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MemberRegistration.this,"Error Occured"+error.toString(),Toast.LENGTH_LONG).show();

            }
        })
        {
            @Override
            public byte[] getBody() throws AuthFailureError {

                String membernamem=membername.getText().toString();
                String fathernamem=mfathernames.getText().toString();
                String mpresentadd=mpresentaddress.getText().toString();
                String parmantaddressm=mpermanentaddress.getText().toString();

                String memailm=memail.getText().toString();
                String bloodm=mblood.getText().toString();
                String mmemberposts=mmemberpost.getText().toString();
                String mcollegenames=mcollegename.getText().toString();
                String mcollegeyears=mcollegeyear.getText().toString();
                String mgraduationfroms=mgraduationfrom.getText().toString();
                String graduationyears=graduationyear.getText().toString();
                String mgraduationsubjects=mgraduationsubject.getText().toString();


                String postgradfroms=postgradfrom.getText().toString();
                String postgradeyears=postgradeyear.getText().toString();
                String postgrdesubjects=postgrdesubject.getText().toString();
                String mcompanynames=mcompanyname.getText().toString();
                String mprofessionaladdresss=mprofessionaladdress.getText().toString();
                String mmobiles=mmobile.getText().toString();

                String mnationalids=mnationalid.getText().toString();
                String mrefnumber=  mreferencenumber.getText().toString();
                String musernamess= musernames.getText().toString();



                JSONObject params = new JSONObject();
                try {
                    params.put("id",4+"");
                    params.put("memberName",membernamem);
                    params.put("fatherName",fathernamem);
                    params.put("presentAddress",mpresentadd);
                    params.put("permanentAddress",parmantaddressm);
                    params.put("mailAddress",memailm);
                    params.put("dateBirth",mdate);
                    params.put("bloodGroup",bloodm);
                    params.put("Profession",memberprofessions);
                    params.put("Post",mmemberposts);
                    params.put("College",mcollegenames);
                    params.put("collegeYear",mcollegeyears);
                    params.put("collegeSubject",msubject);
                    params.put("graduationFrom",mgraduationfroms);
                    params.put("graduationYear",graduationyears);
                    params.put("graduationSubject",mgraduationsubjects);
                    params.put("postgradFrom",postgradfroms);
                    params.put("postgradYear",postgradeyears);
                    params.put("postgradSubject",postgrdesubjects);
                    params.put("companyName",mcompanynames);
                    params.put("professionalAddress",mprofessionaladdresss);
                    params.put("mobileNumber",mmobiles);


                    params.put("nationalID",mnationalids);
                    params.put("referenceNumber",mrefnumber);
                    params.put("memberType",membertypes);
                    params.put("paymentType",payment);
                    params.put("userName",musernamess);
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

        RequestQueue requestQueue= Volley.newRequestQueue(MemberRegistration.this);
        requestQueue.add(stringRequest);
    }
}
