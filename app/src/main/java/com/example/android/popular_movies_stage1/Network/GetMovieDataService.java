package com.example.android.popular_movies_stage1.Network;

import com.example.android.popular_movies_stage1.MoviePageResult;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface GetMovieDataService {
    @GET("movie/popular")
    Call<MoviePageResult> getPopularMovies(@Query("page") int page,@Query("api_key") String userkey);

    @GET("movie/top_rated")
    Call<MoviePageResult> getTopRatedMovies(@Query("page") int page,@Query("api_key") String userkey);
}
