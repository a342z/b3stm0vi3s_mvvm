package com.example.b3stm0vi3s_mvvm.ui.main;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.example.b3stm0vi3s_mvvm.Network.ApiClient;
import com.example.b3stm0vi3s_mvvm.R;
import com.example.b3stm0vi3s_mvvm.models.Movie;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieActivity extends AppCompatActivity {
    @BindView(R.id.imageMM)
    ImageView imageViewMovieImage;
    @BindView(R.id.TVmovieName)
    TextView textViewMovieName;
    @BindView(R.id.TVmovieRS)
    TextView textViewRelease;
    @BindView(R.id.TVmovieOverView)
    TextView textViewOverview;
    //MainViewModel mMainViewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        ButterKnife.bind(this);


        String imageUrl = getIntent().getStringExtra("image_url");
        String movie_des = getIntent().getStringExtra("movie_des");
        String movie_title = getIntent().getStringExtra("movie_title");
        String movie_rs = getIntent().getStringExtra("movie_rs");


        textViewMovieName.setText(movie_title);
        textViewOverview.setText(movie_des);
        textViewRelease.setText(movie_rs);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(imageViewMovieImage);


    }
}