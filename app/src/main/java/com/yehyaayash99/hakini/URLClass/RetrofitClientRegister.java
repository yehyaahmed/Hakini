package com.yehyaayash99.hakini.URLClass;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientRegister {

    private static final String BASE_URL_Signup = UrlClass.urlSignup;
    private static RetrofitClientRegister mInstance;
    private Retrofit retrofit;

    private RetrofitClientRegister() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL_Signup)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClientRegister getInstanceRegister() {
        if (mInstance == null) {
            mInstance = new RetrofitClientRegister();
        }
        return mInstance;
    }

    public ApiClass getApi() {
        return retrofit.create(ApiClass.class);
    }

}
