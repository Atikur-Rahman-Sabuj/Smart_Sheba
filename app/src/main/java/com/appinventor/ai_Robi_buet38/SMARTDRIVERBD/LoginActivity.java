package com.appinventor.ai_Robi_buet38.SMARTDRIVERBD;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    Button driverlogin,ownerlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        driverlogin=findViewById(R.id.driverlogin);
        ownerlogin=findViewById(R.id.ownerlogin);

        driverlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(LoginActivity.this,DriverLogin.class);
                startActivity(intent1);

            }
        });
        ownerlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,OwnerLogin.class);
                startActivity(intent);

            }
        });
    }
}
