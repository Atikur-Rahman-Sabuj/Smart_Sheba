package com.appinventor.ai_Robi_buet38.SMARTDRIVERBD;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DriverProperty {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("driverName")
    @Expose
    private String driverName;

    @SerializedName("fatherName")
    @Expose
    private String fatherName;

    @SerializedName("presentAddress")
    @Expose
    private String presentAddress;

    @SerializedName("permanentAddress")
    @Expose
    private String permanentAddress;

    @SerializedName("driverMobile")
    @Expose
    private String driverMobile;

    @SerializedName("religion")
    @Expose
    private String religion;

    @SerializedName("education")
    @Expose
    private String education;

    @SerializedName("jobLocation")
    @Expose
    private String jobLocation;

    @SerializedName("jobPreference")
    @Expose
    private String jobPreference;

    @SerializedName("refNumber")
    private String refNumber;

    @SerializedName("dlNumber")
    @Expose
    private String dlNumber;

    @SerializedName("nidNumber")
    private String nidNumber;

    @SerializedName("dateBirth")
    @Expose
    private String dateBirth;

    @SerializedName("expYear")
    private String expYear;

    @SerializedName("expType")
    @Expose
    private String expType;

    @SerializedName("expCar")
    @Expose
    private String expCar;

    @SerializedName("startDate")
    @Expose
    private String startDate;

    @SerializedName("expSalary")
    @Expose
    private String expSalary;

    @SerializedName("picture")
    @Expose
    private String picture;

    @SerializedName("remarks")
    @Expose
    private String remarks;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("ownerId")
    @Expose
    private String ownerId;

    @SerializedName("userName")
    @Expose
    private String userName;

    public String getId() {
        return id;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public String getDriverMobile() {
        return driverMobile;
    }

    public String getReligion() {
        return religion;
    }

    public String getEducation() {
        return education;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public String getJobPreference() {
        return jobPreference;
    }

    public String getRefNumber() {
        return refNumber;
    }

    public String getDlNumber() {
        return dlNumber;
    }

    public String getNidNumber() {
        return nidNumber;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public String getExpYear() {
        return expYear;
    }

    public String getExpType() {
        return expType;
    }

    public String getExpCar() {
        return expCar;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getExpSalary() {
        return expSalary;
    }

    public String getPicture() {
        return picture;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getStatus() {
        return status;
    }

    public String getPassword() {
        return password;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getUserName() {
        return userName;
    }
}
