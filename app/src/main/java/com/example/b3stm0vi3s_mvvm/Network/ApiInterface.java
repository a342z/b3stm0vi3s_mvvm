package com.example.b3stm0vi3s_mvvm.Network;

import com.example.b3stm0vi3s_mvvm.models.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("movie/popular")
    Call<Result> getMovies(@Query("api_key") String apiKey);

}
