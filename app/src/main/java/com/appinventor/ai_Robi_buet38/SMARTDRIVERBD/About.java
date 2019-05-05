package com.appinventor.ai_Robi_buet38.SMARTDRIVERBD;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class About extends AppCompatActivity {
    private Button btnShowMap;
    private Button btnLinkFB;
    private Button btnLinkLI;
    private Button btnLinkYT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        btnShowMap = (Button) findViewById(R.id.btnShowMap);
        btnLinkFB = (Button) findViewById(R.id.btnLinkFB);
        btnLinkLI = (Button) findViewById(R.id.btnLinkLI);
        btnLinkYT = (Button) findViewById(R.id.btnLinkYT);
        btnShowMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Smart Driver");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        btnLinkFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/smartdriverbd"));
                startActivity(mapIntent);
            }
        });
        btnLinkLI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/company/smartsheba/"));
                startActivity(mapIntent);
            }
        });
        btnLinkYT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UC3E2KKE3lkx25H0gA-RdUOg"));
                startActivity(mapIntent);
            }
        });

    }
}
