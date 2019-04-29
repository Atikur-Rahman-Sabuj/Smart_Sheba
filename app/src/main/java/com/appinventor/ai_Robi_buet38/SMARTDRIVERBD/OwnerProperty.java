package com.appinventor.ai_Robi_buet38.SMARTDRIVERBD;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OwnerProperty {

    @SerializedName("ownerName")
    @Expose
    private String ownerName;

    @SerializedName("presentAddress")
    @Expose
    private String presentAddress;

    @SerializedName("ownerMobile")
    @Expose
    private String ownerMobile;

    @SerializedName("ownerEmail")
    @Expose
    private String ownerEmail;

    @SerializedName("password")
    @Expose
    private String password;

    public String getOwnerName() {
        return ownerName;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public String getOwnerMobile() {
        return ownerMobile;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public String getPassword() {
        return password;
    }
}
