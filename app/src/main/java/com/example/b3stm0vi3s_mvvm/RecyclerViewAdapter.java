package com.example.b3stm0vi3s_mvvm;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.b3stm0vi3s_mvvm.ui.main.MovieActivity;
import com.example.b3stm0vi3s_mvvm.Network.*;
import com.example.b3stm0vi3s_mvvm.models.Movie;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>  {
    private static String TAG = "RecyclerViewAdapter";

    private Context mContext;
    private List<Movie> mMovieList ;

    public RecyclerViewAdapter(Context context) {
        mContext = context;
    }

    public void setMovieList(List<Movie> movieList) {
        mMovieList = movieList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {



        Log.d(TAG, "onBindViewHolder: called");

        Glide.with(mContext)
                .asBitmap()
                .load(ApiClient.IMAGE_BASE_URL + mMovieList.get(position).getPosterPath())
                .into(holder.movieImage);

        holder.movieName.setText(mMovieList.get(position).getTitle());
        holder.movieRating.setText("Rating: " + String.valueOf(mMovieList.get(position).getVoteAverage()));


        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(mContext, MovieActivity.class);
                intent.putExtra("image_url", ApiClient.BACKDROP_BASE_URL + mMovieList.get(position).getBackdropPath());
                intent.putExtra("movie_des", mMovieList.get(position).getOverview());
                intent.putExtra("movie_title", mMovieList.get(position).getTitle());
                intent.putExtra("movie_rs", mMovieList.get(position).getReleaseDate());

                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        if(mMovieList==null)
            return 0;
        return mMovieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {

        ImageView movieImage;
        TextView movieName;
        TextView movieRating;

        LinearLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            movieImage = itemView.findViewById(R.id.imageMovie);
            movieName = itemView.findViewById(R.id.textViewName);
            movieRating = itemView.findViewById(R.id.textViewRating);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }


    }
}
