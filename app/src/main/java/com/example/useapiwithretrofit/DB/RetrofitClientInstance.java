package com.example.useapiwithretrofit.DB;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    public static final String BASE_URL = "http://88.99.49.132/AMICTestApi/";
    public static Retrofit retrofit;

    public static Retrofit getClientInstance() {
        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())

                    .build();
        }
        return retrofit;
    }
}
