package com.appinventor.ai_Robi_buet38.SMARTDRIVERBD;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class OwnerAdapter extends RecyclerView.Adapter<OwnerAdapter.ExampleViewHolder> {

    private Context mContext;
    private ArrayList<Owner> ownerList;
    private String name;

    public OwnerAdapter(Context context, ArrayList<Owner> exampleList) {
        mContext = context;
        ownerList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.owner_item, parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        Owner drivercurrentItem = ownerList.get(position);

       // String imageUrl = currentItem.getImageUrl();
        String driverid = drivercurrentItem.getId();
        String driverjobpreference=drivercurrentItem.getJobpreference();
        String location = drivercurrentItem.getJoblocation();

       // Toast.makeText(mContext,"ownername:"+name,Toast.LENGTH_SHORT).show();
        holder.ownerid.setText(driverid);
        holder.ownerlocation.setText(location);
        holder.ownerjobpreference.setText(driverjobpreference);
        //Picasso.with(mContext).load(imageUrl).fit().centerInside().into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return ownerList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
      //  public ImageView mImageView;
        public TextView ownerid;
        public TextView ownerlocation;
        public TextView ownerjobpreference;

        public ExampleViewHolder(View itemView) {
            super(itemView);
           // mImageView = itemView.findViewById(R.id.image_view);
            ownerid = itemView.findViewById(R.id.ownersid);
            ownerlocation = itemView.findViewById(R.id.ownerlocation);
            ownerjobpreference=itemView.findViewById(R.id.ownerjobpreference);
        }
    }


}
