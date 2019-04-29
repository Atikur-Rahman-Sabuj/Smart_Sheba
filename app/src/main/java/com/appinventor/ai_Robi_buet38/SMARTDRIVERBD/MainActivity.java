package com.appinventor.ai_Robi_buet38.SMARTDRIVERBD;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
     CardView cardView,company,uber,uberandprivate,demand,rent;
     Button contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);







        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        cardView=findViewById(R.id.privatecard);
        company=findViewById(R.id.companycard);
        uber=findViewById(R.id.ubercard);
        uberandprivate=findViewById(R.id.uberandprivatecard);

        demand=findViewById(R.id.demandcard);
        rent=findViewById(R.id.rentcard);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,PrivateActivity.class);
                startActivity(intent);
            }
        });

        company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,CompanyDriver.class);
                startActivity(intent);
            }
        });

        uber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,UberDriver.class);
                startActivity(intent);
            }
        });
        uberandprivate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Uberprivate.class);
                startActivity(intent);
            }
        });

        demand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,DriverDemand.class);
                startActivity(intent);
            }
        });

        rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,CarRental.class);
                startActivity(intent);
            }
        });
        contact=findViewById(R.id.contactbtn);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,About.class);
                startActivity(intent);
            }
        });



    }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

            Intent aintent= new Intent(MainActivity.this, About.class);
            startActivity(aintent);

            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

            Intent ointent= new Intent(MainActivity.this, OwnerInfo.class);
            startActivity(ointent);

        } else if (id == R.id.availabledrivers) {
            Intent intent= new Intent(MainActivity.this, DriverInfo.class);
            startActivity(intent);
        } else if (id == R.id.nav_manage) {

            Intent intent= new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);

        } else if (id == R.id._driverregistration) {
            Intent intent=new Intent(MainActivity.this,DriverRegistration.class);
            startActivity(intent);

        } else if (id == R.id.ownerregistration) {
            Intent intent2=new Intent(MainActivity.this,OwnerRegistration.class);
            startActivity(intent2);

        }
        else if (id == R.id.memberregistration) {
            Intent intentm=new Intent(MainActivity.this,MemberRegistration.class);
            startActivity(intentm);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
