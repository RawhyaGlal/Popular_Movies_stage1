package com.example.android.popular_movies_stage1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.popular_movies_stage1.Network.RetrofitInstance;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class movieDetails extends AppCompatActivity {

    @BindView(R.id.title)
    TextView mMovieTitle;
    @BindView(R.id.poster)
    ImageView mMoviePoster;
    @BindView(R.id.overview) TextView mMovieOverview;
    @BindView(R.id.release_date) TextView mMovieReleaseDate;
    @BindView(R.id.rating) TextView mMovieRating;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);
        getSupportActionBar().setTitle(R.string.movie_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        movie mMovie = (movie) bundle.getSerializable("movie");
        populateActivity(mMovie);

    }

    private void populateActivity(movie mMovie){
        Picasso.get().load(MainActivity.movieImagePathBuilder(mMovie.getPosterPath())).into(mMoviePoster);
        mMovieTitle.setText(mMovie.getOriginalTitle());
        mMovieOverview.setText(mMovie.getOverview());
        mMovieReleaseDate.setText(mMovie.getReleaseDate());

        String userRatingText = String.valueOf(mMovie.getVoteAverage()) + "/10";
        mMovieRating.setText(userRatingText);
    }




}
