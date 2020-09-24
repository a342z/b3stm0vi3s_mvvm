package com.example.b3stm0vi3s_mvvm.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String API_KEY = "d032214048c9ca94d788dcf68434f385";
    public static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w200/";
    public static final String BACKDROP_BASE_URL = "https://image.tmdb.org/t/p/w780/";
    private static Retrofit retrofit = null;
    public static final String BASE_URL = "https://api.themoviedb.org/3/";

    public static Retrofit getClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }


        return retrofit;
    }
}
