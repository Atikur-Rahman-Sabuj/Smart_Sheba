package com.appinventor.ai_Robi_buet38.SMARTDRIVERBD;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OwnerDetails extends AppCompatActivity {

    Owner item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_details);

        // Intent i = getIntent();
        int data = (int) getIntent().getExtras().get("value");
        //item = (ExampleItem) data.getParcelable("object");
        item= OwnerInfo.ownerlist.get(data);


        TextView ownername=findViewById(R.id.ownersname);
        TextView ownerworkinghour=findViewById(R.id.ownerworkinghours);
        TextView ownerjobreference=findViewById(R.id.ownerjobreferences);
        TextView ownerjoblocation=findViewById(R.id.ownerjoblocation);
        TextView ownercarname=findViewById(R.id.ownercarname);
        TextView ownerstartdate=findViewById(R.id.ownerstartdate);

        TextView owneroffersalary=findViewById(R.id.owneroffersalary);
        TextView ownerexperience=findViewById(R.id.ownerexperience);

        TextView owneraccomodation=findViewById(R.id.owneraccomodation);
        TextView ownerlunch=findViewById(R.id.ownerlunch);



        ownername.setText(item.getOwnername());
        ownerworkinghour.setText(item.getJoblocation());
        ownerjobreference.setText(item.getJobpreference());
        ownerjoblocation.setText(item.getJoblocation());
        ownercarname.setText(item.getCarname());
        ownerstartdate.setText(item.getStartdate());

        owneroffersalary.setText(item.getOffersalary());
        ownerexperience.setText(item.getExpyear());
        owneraccomodation.setText(item.getAccomodation());
        ownerlunch.setText(item.getLunch());
    }
}
