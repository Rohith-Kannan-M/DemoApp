package com.example.demoapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("register.php")
    abstract Call<String> getUserRegi(
            @Field("name") String name,
            @Field("email") String uname,
            @Field("pass") String password
    );

    @FormUrlEncoded
    @POST("login.php")
    Call<String> getUserLogin(

            @Field("email") String uname,
            @Field("pass") String password
    );

   @FormUrlEncoded
    @POST("mycourse.php")
    Call<List<MyCourses>> getMycourses(
           @Field("userid") String huserid
   );

    @FormUrlEncoded
    @POST("allcourses.php")
    Call<List<courses>> getcourses(
            @Field("userid") String huserid
    );


    @FormUrlEncoded
    @POST("customerregister.php")
    abstract Call<String> getCustomerRegi(
            @Field("userid") String tid,
            @Field("customername") String cname,
            @Field("customernumber") String cnum
    );

    /*@FormUrlEncoded
    @POST("transactions.php")
    Call<List<PostT>> getPostT(
            @Field("userid") String usid,
            @Field("custid") String cid
    );*/

    @FormUrlEncoded
    @POST("transactionregister.php")
    abstract Call<String> getTransdet(
            @Field("userid") String tid,
            @Field("custid") String cid,
            @Field("type") String cname,
            @Field("amount") String cnum,
            @Field("reason") String reason
    );

    @FormUrlEncoded
    @POST("courseregister.php")
    abstract Call<String> getCourseRegi(
            @Field("userid") String userid,
            @Field("courseid") String courseid
    );

}
