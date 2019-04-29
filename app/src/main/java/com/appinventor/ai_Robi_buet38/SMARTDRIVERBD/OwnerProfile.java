package com.appinventor.ai_Robi_buet38.SMARTDRIVERBD;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OwnerProfile extends AppCompatActivity {

    OwnerProperty ownerProperty;
    TextView ownerprofilename,ownerprofilepresentaddress,ownerprofilephone,ownerprofileemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_profile);

        initializeAll();
        ownerProperty=  OwnerLogin.ownerproperties.get(0);

        ownerprofilename.setText(ownerProperty.getOwnerName());
        ownerprofilepresentaddress.setText(ownerProperty.getPresentAddress());
        ownerprofilephone.setText(ownerProperty.getOwnerMobile());
        ownerprofileemail.setText(ownerProperty.getOwnerEmail());
    }

    private void initializeAll() {

        ownerprofilename=findViewById(R.id.ownernameprofile);
        ownerprofilepresentaddress=findViewById(R.id.ownerprofilepresentaddress);
        ownerprofilephone=findViewById(R.id.profileownermobile);
        ownerprofileemail=findViewById(R.id.profileownermail);


    }
}
