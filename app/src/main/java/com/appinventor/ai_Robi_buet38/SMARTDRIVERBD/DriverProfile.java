package com.appinventor.ai_Robi_buet38.SMARTDRIVERBD;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DriverProfile extends AppCompatActivity {

    DriverProperty driverProperty;
    TextView drivername,driverpresentaddress,driverpermanentaddress,driverphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_profile);


        drivername=findViewById(R.id.drivername);
        driverpresentaddress=findViewById(R.id.presentaddress);
        driverpermanentaddress=findViewById(R.id.permantaddress);
        driverphone=findViewById(R.id.drivermobile);


        driverProperty = DriverLogin.driverlist.get(0);


        drivername.setText(driverProperty.getDriverName());
        driverpresentaddress.setText(driverProperty.getPresentAddress());
        driverpermanentaddress.setText(driverProperty.getPermanentAddress());
        driverphone.setText(driverProperty.getDriverMobile());
    }
}
