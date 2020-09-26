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

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<StudentModel> mLearnersList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public RecyclerViewAdapter() {
    }

    public void SetData(List<StudentModel> mLearnersList){

        this.mLearnersList = mLearnersList;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        return new RecyclerViewAdapter.MyViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.item_learners,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        StudentModel learners = mLearnersList.get(position);

        Picasso.Builder builder = new Picasso.Builder(mContext);
        builder.downloader(new OkHttp3Downloader(mContext));
        builder.build().load(learners.getBadgeUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.learnersPhoto);


         String name = learners.getName();
         String hours = learners.getHours();
         String country = learners.getCountry();


         holder.learnersName.setText(name);
         holder.learnersHours.setText(hours);
         holder.learnersCountry.setText(country);



    }

    @Override
    public int getItemCount() {
        return mLearnersList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView learnersPhoto;
        TextView learnersName;
        TextView learnersHours;
        TextView learnersCountry;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            learnersPhoto = itemView.findViewById(R.id.learners_img);
            learnersName = itemView.findViewById(R.id.learners_name);
            learnersHours = itemView.findViewById(R.id.learners_hours);
            learnersCountry = itemView.findViewById(R.id.learners_country);
        }
    }
}
