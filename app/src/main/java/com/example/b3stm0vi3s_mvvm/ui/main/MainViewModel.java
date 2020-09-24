package com.example.b3stm0vi3s_mvvm.ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.b3stm0vi3s_mvvm.Network.ApiClient;
import com.example.b3stm0vi3s_mvvm.Network.ApiInterface;
import com.example.b3stm0vi3s_mvvm.models.Movie;
import com.example.b3stm0vi3s_mvvm.models.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    MutableLiveData<List<Movie>> mMoviesMutableLiveData = new MutableLiveData<>();
    private static final String TAG = "MainViewModel";

public void getMovies(){

    ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
    Call<Result> call = apiService.getMovies(ApiClient.API_KEY);

    call.enqueue(new Callback<Result>() {
        @Override
        public void onResponse(Call<Result> call, Response<Result> response) {
            mMoviesMutableLiveData.setValue(response.body().getMovies());
        }

        @Override
        public void onFailure(Call<Result> call, Throwable t) {

        }
    });

}
}
