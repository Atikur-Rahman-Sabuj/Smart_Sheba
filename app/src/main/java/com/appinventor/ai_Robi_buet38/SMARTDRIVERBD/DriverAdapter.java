package com.appinventor.ai_Robi_buet38.SMARTDRIVERBD;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DriverAdapter extends RecyclerView.Adapter<DriverAdapter.ExampleViewHolder> {

    private Context mContext;
    private ArrayList<Driver> driverList;
    private String name;

    public DriverAdapter(Context context, ArrayList<Driver> exampleList) {
        mContext = context;
        driverList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.driver_item, parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        Driver drivercurrentItem = driverList.get(position);

       // String imageUrl = currentItem.getImageUrl();
        String driverid = drivercurrentItem.getId();
        String driverjobpreference=drivercurrentItem.getJobpreference();
        String location = drivercurrentItem.getJoblocation();

       // Toast.makeText(mContext,"ownername:"+name,Toast.LENGTH_SHORT).show();
        holder.driverid.setText(driverid);
        holder.driverlocation.setText(location);
        holder.driverjobpreference.setText(driverjobpreference);
        //Picasso.with(mContext).load(imageUrl).fit().centerInside().into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return driverList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
      //  public ImageView mImageView;
        public TextView driverid;
        public TextView driverlocation;
        public TextView driverjobpreference;

        public ExampleViewHolder(View itemView) {
            super(itemView);
           // mImageView = itemView.findViewById(R.id.image_view);
            driverid = itemView.findViewById(R.id.driverid);
            driverlocation = itemView.findViewById(R.id.driverlocation);
            driverjobpreference=itemView.findViewById(R.id.driverjobpreference);
        }
    }


}
