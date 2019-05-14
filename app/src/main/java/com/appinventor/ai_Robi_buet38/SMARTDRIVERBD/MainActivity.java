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
     CardView cvDriverService,cvCarRentalService, cvHomeShiftingService, cvOfficeSupportService, cvCarServicingService, cvSparePartService;
     private  CardView cvDress, cvMedical, cvVehicle, cvElectronics, cvHotel, cvOthers;
     private CardView cvFeri, cvDrivingTraining, cvSecutityService;
     Button contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cvDress = findViewById(R.id.cvDress);
        cvMedical = findViewById(R.id.cvMedical);
        cvVehicle = findViewById(R.id.cvVehicle);
        cvElectronics = findViewById(R.id.cvElectronics);
        cvHotel = findViewById(R.id.cvHotel);
        cvOthers = findViewById(R.id.cvOthers);
        cvFeri = findViewById(R.id.cvFeri);
        cvDrivingTraining = findViewById(R.id.cvDrivingTraining);
        cvSecutityService = findViewById(R.id.cvSecutityService);




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        cvDriverService =findViewById(R.id.drivercard);
        cvCarRentalService=findViewById(R.id.carrentalcard);
        cvHomeShiftingService =findViewById(R.id.homeshiftingcard);
        cvOfficeSupportService =findViewById(R.id.officesupportcard);
        cvCarServicingService =findViewById(R.id.carservicingcard);
        cvSparePartService =findViewById(R.id.sparepartscard);
        cvDriverService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, ServiceDriverActivity.class);
                startActivity(intent);
            }
        });

        cvCarRentalService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, ServiceCarRentalActivity.class);
                startActivity(intent);
            }
        });

        cvHomeShiftingService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, ServiceHomeShiftingActivity.class);
                startActivity(intent);
            }
        });
        cvOfficeSupportService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, ServiceOfficeSupportActivity.class);
                startActivity(intent);
            }
        });

        cvCarServicingService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, ServiceCarServicingActivity.class);
                startActivity(intent);
            }
        });

        cvSparePartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, ServiceSpartPartActivity.class);
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
        cvDress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,OfferDressActivity.class);
                startActivity(intent);
            }
        });
        cvMedical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,OfferMedicalActivity.class);
                startActivity(intent);
            }
        });
        cvVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,OfferVehicleActivity.class);
                startActivity(intent);
            }
        });
        cvElectronics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,OfferElectronicsActivity.class);
                startActivity(intent);
            }
        });
        cvHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,OfferHotelActivity.class);
                startActivity(intent);
            }
        });
        cvOthers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,OfferOtherActivity.class);
                startActivity(intent);
            }
        });
        cvFeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,FeriServiceActivity.class);
                startActivity(intent);
            }
        });
        cvDrivingTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,DrivingTrainingActivity.class);
                startActivity(intent);
            }
        });
        cvSecutityService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SecurityServiceActivity.class);
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

            Intent aintent = new Intent(MainActivity.this, About.class);
            startActivity(aintent);
        }
            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//            Intent ointent= new Intent(MainActivity.this, OwnerInfo.class);
//            startActivity(ointent);
//
//        } else if (id == R.id.availabledrivers) {
//            Intent intent= new Intent(MainActivity.this, DriverInfo.class);
//            startActivity(intent);
//        } else if (id == R.id.nav_manage) {
//
//            Intent intent= new Intent(MainActivity.this, LoginActivity.class);
//            startActivity(intent);
//
//        } else if (id == R.id._driverregistration) {
//            Intent intent=new Intent(MainActivity.this,DriverRegistration.class);
//            startActivity(intent);
//
//        } else if (id == R.id.ownerregistration) {
//            Intent intent2=new Intent(MainActivity.this,OwnerRegistration.class);
//            startActivity(intent2);
//
//        }
        else if (id == R.id.memberregistration) {
            Intent intentm=new Intent(MainActivity.this,MemberRegistration.class);
            startActivity(intentm);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
