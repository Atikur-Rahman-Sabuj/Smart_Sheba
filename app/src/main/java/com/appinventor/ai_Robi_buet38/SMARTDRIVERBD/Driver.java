package com.appinventor.ai_Robi_buet38.SMARTDRIVERBD;

public class Driver {

    private String id;
    private String drivername;
    private String joblocation;
    private String jobpreference;
    private String experienceyear;
    private String experiencetype;
    private String experienccar;


    public Driver(String id, String drivername, String jobLocation, String jobpreference, String experience, String experiencetype, String experiencecar) {
        this.id=id;
        this.drivername=drivername;
        this.joblocation=jobLocation;
        this.jobpreference=jobpreference;
        this.experienceyear=experience;
        this.experiencetype=experiencetype;
        this.experienccar=experiencecar;
    }

    public String getId() {
        return id;
    }

    public String getDrivername() {
        return drivername;
    }

    public String getJoblocation() {
        return joblocation;
    }

    public String getJobpreference() {
        return jobpreference;
    }

    public String getExperienceyear() {
        return experienceyear;
    }

    public String getExperiencetype() {
        return experiencetype;
    }

    public String getExperienccar() {
        return experienccar;
    }
}
