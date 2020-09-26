package com.example.leaderboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LearningFragment extends Fragment {

    View view;
     RecyclerView myRecyclerView;
     List<StudentModel> mLearners;
     RecyclerViewAdapter mRecyclerViewAdapter;
     ProgressBar mProgressBar;

    public LearningFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.learning_fragment1, container,false);
        myRecyclerView = view.findViewById(R.id.learners_recycler);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        mRecyclerViewAdapter = new RecyclerViewAdapter();

        // Set up progress before call
        mProgressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        mProgressBar.setVisibility(View.VISIBLE);

        getAllRetrofitUsers();

        return view;

    }

    public void getAllRetrofitUsers(){
        Call<List<StudentModel>> learnersList = LearnersApiClient.getLearnersResponse().learnersResponseList();
        learnersList.enqueue(new Callback<List<StudentModel>>() {
            @Override
            public void onResponse(Call<List<StudentModel>> call, Response<List<StudentModel>> response) {
                if (response.isSuccessful()){
                    mProgressBar.setVisibility(view.GONE);
                    List<StudentModel> learnersList1 = response.body();
                    mRecyclerViewAdapter.SetData(learnersList1);
                    myRecyclerView.setAdapter(mRecyclerViewAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<StudentModel>> call, Throwable t) {
                Log.e("failed", t.getLocalizedMessage());

            }
        });

    }
}