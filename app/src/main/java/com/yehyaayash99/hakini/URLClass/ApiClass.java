package com.yehyaayash99.hakini.URLClass;

import com.yehyaayash99.hakini.Items.LoginResponse;
import com.yehyaayash99.hakini.Items.TherapistItem;
import com.yehyaayash99.hakini.Items.UpdateData2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiClass {


    @FormUrlEncoded
    @POST("signup")
    Call<LoginResponse> userRegister(
            @Field("email") String email,
            @Field("password") String password,
            @Field("username") String username
    );

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> userLogin(
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("update")
    Call<UpdateData> updateData(
            @Header("Authorization") String Authorization,
            @Field("gender") String gender,
            @Field("country") String country,
            @Field("dob") String dob,
            @Field("career") String career

    );

    @FormUrlEncoded
    @POST("appointment")
    Call<UpdateData> uploadTime(
            @Header("Authorization") String Authorization,
            @Field("time") String time,
            @Field("date") String date,
            @Field("therapist_id") String therapist_id,
            @Field("type") String type,
            @Field("cost") String cost
    );

    @GET("matching")
    Call<List<TherapistItem>> getTherapist(
            @Header("Authorization") String Authorization
    );

    @GET("therapists")
    Call<List<TherapistItem>> getAllTherapist(
    );

    @GET("availabilities?")
    Call<List<String>> getTimes(
            @Query("providerId") int providerId,
            @Query("serviceId") int serviceId,
            @Query("date") String date

    );

    @FormUrlEncoded
    @POST("survey")
    Call<UpdateData> uploadAnswerQuestion(
            @Header("Authorization") String Authorization,
            @Field("study") String study,
            @Field("age") String age,
            @Field("quick_solution") String quick_solution,
            @Field("disorders") String disorders,
            @Field("prev_self_health") String prev_self_health,
            @Field("prev_shock") String prev_shock,
            @Field("pressure_conditions") String pressure_conditions,
            @Field("language") String language,
            @Field("help_in") String help_in,
            @Field("payment") String payment,
            @Field("more_ques") String more_ques

    );

    @FormUrlEncoded
    @POST("subscription")
    Call<UpdateData2> uploadSubScription(
            @Header("Authorization") String Authorization,
            @Field("subscription_type") String subscription_type

    );

}
