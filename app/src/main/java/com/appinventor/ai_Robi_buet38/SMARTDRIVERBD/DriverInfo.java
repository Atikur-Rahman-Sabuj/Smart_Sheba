package com.appinventor.ai_Robi_buet38.SMARTDRIVERBD;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DriverInfo extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private RecyclerView mRecyclerViewdriver;
    private DriverAdapter driverAdapter;
    public static ArrayList<Driver> driverList;
    private RequestQueue mRequestdriverQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_info);


        mRecyclerViewdriver = findViewById(R.id.recycler_viewdriver);
        mRecyclerViewdriver.setHasFixedSize(true);
        mRecyclerViewdriver.setLayoutManager(new LinearLayoutManager(this));

        driverList = new ArrayList<>();

        mRequestdriverQueue = Volley.newRequestQueue(this);



            parseJSON();


    }

    private void parseJSON() {
       //ProgressBar progressBar= findViewById(R.id.progressBar);

       // progressDialog =ProgressDialog.show(DriverInfo.this,"Synchronizing","Loading!!  Please wait",true);
        // String url = "https://pixabay.com/api/?key=5303976-fd6581ad4ac165d1b75cc15b3&q=kitten&image_type=photo&pretty=true";
        String url = "https://sd.smrobi.com/api/DriverRegApi.php";


        JsonObjectRequest driverrequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONArray jsonArray = (JSONArray) response.getJSONArray("result");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject hit = jsonArray.getJSONObject(i);
                        String id = hit.getString("id");
                        String drivername = hit.getString("driverName");
                        String jobLocation = hit.getString("jobLocation");

                        String jobpreference = hit.getString("jobPreference");
                        String experience = hit.getString("expYear");
                        String experiencetype = hit.getString("expType");
                        String experiencecar = hit.getString("expCar");




                        driverList.add(new Driver(id, drivername, jobLocation, jobpreference, experience,experiencetype,experiencecar));
                        //Toast.makeText(DriverInfo.this,"ownername"+jobpreference+"jobpreference:"+id,Toast.LENGTH_SHORT).show();
                    }


                    driverAdapter = new DriverAdapter(DriverInfo.this, driverList);
                    mRecyclerViewdriver.setAdapter(driverAdapter);
                    findViewById(R.id.progressBar).setVisibility(View.GONE);
                    mRecyclerViewdriver.addOnItemTouchListener(new RecyclerTouchListener(DriverInfo.this, mRecyclerViewdriver, new RecyclerTouchListener.ClickListener() {
                        @Override
                        public void onClick(View view, int position) {

                            Driver driveritem= driverList.get(position);
                           // Toast.makeText(DriverInfo.this,"This is id:"+item.getId(),Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(DriverInfo.this,DetailsActivity.class);
                            intent.putExtra("value", position);
                            startActivity(intent);

                        }

                        @Override
                        public void onLongClick(View view, int position) {

                        }
                    }));


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });





        mRequestdriverQueue.add(driverrequest);
    }
}
