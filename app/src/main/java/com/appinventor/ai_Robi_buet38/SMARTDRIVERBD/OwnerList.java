package com.appinventor.ai_Robi_buet38.SMARTDRIVERBD;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class OwnerList {

    @SerializedName("result")
    @Expose
    private ArrayList<OwnerProperty> ownerProperties = new ArrayList<>();

    public ArrayList<OwnerProperty> getOwnerProperties() {
        return ownerProperties;
    }

    public void setOwnerProperties(ArrayList<OwnerProperty> ownerProperties) {
        this.ownerProperties = ownerProperties;
    }
}
