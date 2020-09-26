package com.example.leaderboard;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LearnersResponse {

    @GET("hours")
    Call<List<StudentModel>> learnersResponseList();
}
