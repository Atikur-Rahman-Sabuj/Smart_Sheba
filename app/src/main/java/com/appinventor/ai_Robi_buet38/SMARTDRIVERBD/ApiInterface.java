package com.appinventor.ai_Robi_buet38.SMARTDRIVERBD;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("loginDriver.php")
    Call<DriverList> getDriverInfo(@Query("driverMobile") String driverMobile);

    @GET("login.php")
    Call<OwnerList> getOwnerInfo(@Query("ownerMobile") String ownerMobile);
}
