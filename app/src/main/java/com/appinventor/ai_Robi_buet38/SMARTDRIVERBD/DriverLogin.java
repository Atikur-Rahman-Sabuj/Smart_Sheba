package com.appinventor.ai_Robi_buet38.SMARTDRIVERBD;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DriverLogin extends AppCompatActivity {

    String mobile="01765349878";
    EditText driverloginmobile,driverloginpassword;
    String  drivermobile,driverpassword;


    Button buttonget;
    ApiInterface apiInterface;
    static ArrayList<DriverProperty> driverlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_driver_login);
        buttonget=findViewById(R.id.button_get);
        driverloginmobile=findViewById(R.id.logindrivermobile);
        driverloginpassword=findViewById(R.id.logindriverpassword);


        buttonget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drivermobile=driverloginmobile.getText().toString();
                driverpassword=driverloginpassword.getText().toString();


                apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
                Call<DriverList> driverproperty=apiInterface.getDriverInfo(drivermobile);
                driverproperty.enqueue(new Callback<DriverList>() {
                    @Override
                    public void onResponse(Call<DriverList> call, Response<DriverList> response) {

                        driverlist=response.body().getContacts();

                        if(driverlist.get(0).getDriverMobile().equals(drivermobile) && driverlist.get(0).getPassword().equals(driverpassword)){
                            Toast.makeText(DriverLogin.this,"You Logged in Successfully",Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(DriverLogin.this,DriverProfile.class);
                            startActivity(intent);

                        }else{

                            Toast.makeText(DriverLogin.this,"Wrong username and password",Toast.LENGTH_LONG).show();
                        }


                    }

                    @Override
                    public void onFailure(Call<DriverList> call, Throwable t) {

                    }
                });


            }
        });
    }
}
