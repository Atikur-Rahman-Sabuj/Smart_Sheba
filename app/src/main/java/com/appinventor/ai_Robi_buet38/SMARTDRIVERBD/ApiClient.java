package com.appinventor.ai_Robi_buet38.SMARTDRIVERBD;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String baseurl="http://sd.smrobi.com/api/";
    public static Retrofit retrofit;

    public static Retrofit getApiClient(){

        if(retrofit==null){

            retrofit=new Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit;
    }

}
