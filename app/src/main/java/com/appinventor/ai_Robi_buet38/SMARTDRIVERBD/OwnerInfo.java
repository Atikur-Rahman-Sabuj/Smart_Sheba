package com.appinventor.ai_Robi_buet38.SMARTDRIVERBD;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

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

public class OwnerInfo extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private RecyclerView mRecyclerViewowner;
    private OwnerAdapter ownerAdapter;
    public static ArrayList<Owner> ownerlist;
    private RequestQueue mRequestownerQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_info);

        mRecyclerViewowner = findViewById(R.id.recycler_viewowner);
        mRecyclerViewowner.setHasFixedSize(true);
        mRecyclerViewowner.setLayoutManager(new LinearLayoutManager(this));

        ownerlist = new ArrayList<>();

        mRequestownerQueue = Volley.newRequestQueue(this);
        parseJSON();
    }

    private void parseJSON() {

       // progressDialog =ProgressDialog.show(OwnerInfo.this,"Synchronising","Loading!!  Please wait",true);
        // String url = "https://pixabay.com/api/?key=5303976-fd6581ad4ac165d1b75cc15b3&q=kitten&image_type=photo&pretty=true";
        String url = "https://sd.smrobi.com/api/OwnerRegApi.php";


        JsonObjectRequest driverrequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONArray jsonArray = (JSONArray) response.getJSONArray("result");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject hit = jsonArray.getJSONObject(i);
                        String id = hit.getString("id");
                        String ownername = hit.getString("ownerName");
                        String workinghours = hit.getString("workingHours");

                        String jobpreference = hit.getString("jobPreference");
                        String joblocation = hit.getString("jobLocation");
                        String carname = hit.getString("carName");
                        String startdate = hit.getString("startDate");

                        String offersalary = hit.getString("offerSalary");
                        String expyear = hit.getString("expYear");
                        String accomodation = hit.getString("accomodation");
                        String lunch = hit.getString("lunch");




                        ownerlist.add(new Owner(id, ownername, workinghours, jobpreference, joblocation,carname,startdate,offersalary,expyear,accomodation,lunch));
                        //Toast.makeText(OwnerInfo.this,"ownername"+jobpreference+"jobpreference:"+dutyhours,Toast.LENGTH_SHORT).show();
                    }


                    ownerAdapter = new OwnerAdapter(OwnerInfo.this, ownerlist);
                    mRecyclerViewowner.setAdapter(ownerAdapter);
                    findViewById(R.id.progressBar2).setVisibility(View.GONE);
                    mRecyclerViewowner.addOnItemTouchListener(new RecyclerTouchListener(OwnerInfo.this, mRecyclerViewowner, new RecyclerTouchListener.ClickListener() {
                        @Override
                        public void onClick(View view, int position) {

                            Owner owneritem= ownerlist.get(position);
                            //Toast.makeText(OwnerInfo.this,"This is id:"+item.getId(),Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(OwnerInfo.this,OwnerDetails.class);
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





        mRequestownerQueue.add(driverrequest);
    }
}
