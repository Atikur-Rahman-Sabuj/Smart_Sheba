package com.appinventor.ai_Robi_buet38.SMARTDRIVERBD;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DriverList {

    @SerializedName("result")
    @Expose
    private ArrayList<DriverProperty> contacts = new ArrayList<>();

    public ArrayList<DriverProperty> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<DriverProperty> contacts) {
        this.contacts = contacts;
    }
}
