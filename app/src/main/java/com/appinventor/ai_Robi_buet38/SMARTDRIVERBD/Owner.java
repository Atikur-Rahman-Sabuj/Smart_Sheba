package com.appinventor.ai_Robi_buet38.SMARTDRIVERBD;

public class Owner {

    private String id;
    private String ownername;
    private String workinghours;
    private String jobpreference;
    private String joblocation;
    private String carname;
    private String startdate;

    private String offersalary;
    private String expyear;
    private String accomodation;
    private String lunch;


    public String getId() {
        return id;
    }

    public String getOwnername() {
        return ownername;
    }

    public String getWorkinghours() {
        return workinghours;
    }

    public String getJobpreference() {
        return jobpreference;
    }

    public String getJoblocation() {
        return joblocation;
    }

    public String getCarname() {
        return carname;
    }

    public String getStartdate() {
        return startdate;
    }

    public String getOffersalary() {
        return offersalary;
    }

    public String getExpyear() {
        return expyear;
    }

    public String getAccomodation() {
        return accomodation;
    }

    public String getLunch() {
        return lunch;
    }

    public Owner(String id, String ownername, String workinghours, String jobpreference, String joblocation, String carname, String startdate, String offersalary, String expyear, String accomodation, String lunch) {

        this.id=id;
        this.ownername=ownername;
        this.workinghours=workinghours;
        this.jobpreference=jobpreference;
        this.joblocation=joblocation;
        this.carname=carname;
        this.startdate=startdate;
        this.offersalary=offersalary;
        this.expyear=expyear;
        this.accomodation=accomodation;
        this.lunch=lunch;

    }


}
