package com.appinventor.ai_Robi_buet38.SMARTDRIVERBD;

public class ExampleItem {
    private String id;
    private String ownername;
    private String dutyhours;
    private String jobpreference;
    private String carname;
    private String jobLocation;
    private String startDate;
    private String offersalary;
    private String experience;
    private String accomodation;
    private String lunch;


    public String getOwnername() {
        return ownername;
    }

    public String getDutyhours() {
        return dutyhours;
    }

    public String getJobpreference() {
        return jobpreference;
    }

    public String getCarname() {
        return carname;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getOffersalary() {
        return offersalary;
    }

    public String getExperience() {
        return experience;
    }

    public String getAccomodation() {
        return accomodation;
    }

    public String getLunch() {
        return lunch;
    }

    public String getId() {
        return id;
    }

    public ExampleItem(String id, String ownername, String dutyhours, String jobpreference, String carname, String jobLocation, String startDate, String offersalary, String experience, String accomodation, String lunch) {
        this.id=id;
        this.ownername=ownername;
        this.dutyhours=dutyhours;
        this.jobpreference=jobpreference;
        this.carname=carname;
        this.jobLocation=jobLocation;
        this.startDate=startDate;
        this.offersalary=offersalary;
        this.experience=experience;
        this.accomodation=accomodation;
        this.lunch=lunch;

    }

}
