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

public class OwnerLogin extends AppCompatActivity {

    String mobile="01708169433";
    EditText ownerloginmobile,ownerloginpassword;
    String  ownermobile,ownerpassword;

    Button buttongetowner;
    ApiInterface apiInterface;
    static ArrayList<OwnerProperty> ownerproperties;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_login);
        buttongetowner=findViewById(R.id.button_getowner);

        ownerloginmobile=findViewById(R.id.loginownermobile);
        ownerloginpassword=findViewById(R.id.loginownerpassword);


        buttongetowner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ownermobile=ownerloginmobile.getText().toString();
                ownerpassword=ownerloginpassword.getText().toString();

                apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
                Call<OwnerList> ownerproperty=apiInterface.getOwnerInfo(ownermobile);

                ownerproperty.enqueue(new Callback<OwnerList>() {
                    @Override
                    public void onResponse(Call<OwnerList> call, Response<OwnerList> response) {
                        ownerproperties=response.body().getOwnerProperties();

                        if(ownerproperties.get(0).getOwnerMobile().equals(ownermobile) && ownerproperties.get(0).getPassword().equals(ownerpassword) ){
                            Toast.makeText(OwnerLogin.this,"You Logged in Successfully",Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(OwnerLogin.this,OwnerProfile.class);
                            startActivity(intent);

                        }
                        else{

                            Toast.makeText(OwnerLogin.this,"something wrong"+ownerproperties.get(0).getOwnerMobile(),Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<OwnerList> call, Throwable t) {

                    }
                });



            }
        });
    }
}
