package com.example.leaderboard;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SkillIQFragment extends Fragment {

    View view;
    private SkillRecyclerAdapter mSkillRecyclerAdapter;
    private RecyclerView skillRecyclerView;
    ProgressBar mSkillProgressBar;


    public SkillIQFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       view = inflater.inflate(R.layout.skill_iq_fragment2, container, false);
       skillRecyclerView = (RecyclerView) view.findViewById(R.id.skill_recycler);
       skillRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
       mSkillRecyclerAdapter = new SkillRecyclerAdapter();

       //Setup the progressbar
        mSkillProgressBar = (ProgressBar) view.findViewById(R.id.Skill_progressBar);
        mSkillProgressBar.setVisibility(View.VISIBLE);


       getAllSkillRetrofitUsers();
       return view;
    }

    public void getAllSkillRetrofitUsers(){
        Call<List<SkillModel>> skillList = SkillApiClient.getSkillResponse().skillModelList();
        skillList.enqueue(new Callback<List<SkillModel>>() {
            @Override
            public void onResponse(Call<List<SkillModel>> call, Response<List<SkillModel>> response) {
                if (response.isSuccessful()){
                    mSkillProgressBar.setVisibility(View.GONE);
                    List<SkillModel> skillList1 = response.body();
                    mSkillRecyclerAdapter.skillSetData(skillList1);
                    skillRecyclerView.setAdapter(mSkillRecyclerAdapter);

                }
            }
            @Override
            public void onFailure(Call<List<SkillModel>> call, Throwable t) {

                Log.e("Failed", t.getLocalizedMessage());

            }
        });
    }
}