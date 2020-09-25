package com.example.leaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SkillRecyclerAdapter extends RecyclerView.Adapter<SkillRecyclerAdapter.SkillViewHolder> {
    Context skillContext;
    List<SkillModel> skillData;

    public SkillRecyclerAdapter() {
    }

    public void skillSetData(List<SkillModel> skillData){
        this.skillData = skillData;
    }

    @NonNull
    @Override
    public SkillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        skillContext = parent.getContext();
        return new SkillRecyclerAdapter.SkillViewHolder(LayoutInflater.from(skillContext)
                .inflate(R.layout.item_skill,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull SkillViewHolder holder, int position) {

        SkillModel skillModel = skillData.get(position);

        Picasso.Builder builder = new Picasso.Builder(skillContext);
        builder.downloader(new OkHttp3Downloader(skillContext));
        builder.build().load(skillModel.getBadgeUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.skillImage);


        String name = skillModel.getName();
         String score = skillModel.getScore();
         String country = skillModel.getCountry();


         holder.skillName.setText(name);
         holder.skillScore.setText(score);
         holder.skillCountry.setText(country);


    }

    @Override
    public int getItemCount() {
        return skillData.size();
    }

    public static class SkillViewHolder extends RecyclerView.ViewHolder{
        private TextView skillName;
        private TextView skillScore;
        private TextView skillCountry;
        private ImageView skillImage;

        public SkillViewHolder(@NonNull View itemView) {
            super(itemView);
            skillName = (TextView) itemView.findViewById(R.id.skill_name);
            skillScore = (TextView) itemView.findViewById(R.id.skill_hours);
            skillCountry = (TextView) itemView.findViewById(R.id.skill_country);
            skillImage = (ImageView) itemView.findViewById(R.id.skill_image);
        }
    }
}
