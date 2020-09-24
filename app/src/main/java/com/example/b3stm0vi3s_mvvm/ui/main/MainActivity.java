package com.example.b3stm0vi3s_mvvm.ui.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.b3stm0vi3s_mvvm.R;
import com.example.b3stm0vi3s_mvvm.RecyclerViewAdapter;
import com.example.b3stm0vi3s_mvvm.models.Movie;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    MainViewModel mMainViewModel;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mMainViewModel.getMovies();

        final RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(recyclerViewAdapter);

        mMainViewModel.mMoviesMutableLiveData.observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                recyclerViewAdapter.setMovieList(movies);
            }
        });


    }
}