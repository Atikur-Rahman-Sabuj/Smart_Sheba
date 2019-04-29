package com.appinventor.ai_Robi_buet38.SMARTDRIVERBD;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    Driver item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Intent i = getIntent();
        // Intent i = getIntent();
        int data = (int) getIntent().getExtras().get("value");
        //item = (ExampleItem) data.getParcelable("object");
        item=DriverInfo.driverList.get(data);


        TextView drivername=findViewById(R.id.driversname);
        TextView driverjoblocation=findViewById(R.id.driverjoblocation);
        TextView driverjobpreference=findViewById(R.id.driverjobreferences);
        TextView driverexperience=findViewById(R.id.driverexperience);
        TextView driverexperiencetype=findViewById(R.id.driverexperiencetype);
        TextView carexperience=findViewById(R.id.carexperience);



        drivername.setText(item.getDrivername());
        driverjoblocation.setText(item.getJoblocation());
        driverjobpreference.setText(item.getJobpreference());
        driverexperience.setText(item.getExperienceyear());
        driverexperiencetype.setText(item.getExperiencetype());
        carexperience.setText(item.getExperienccar());
    }
}
