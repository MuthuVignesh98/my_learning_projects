package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class ViewPagerAdapter extends FragmentStateAdapter {
      List<String> titles;
     List<Model2> examList;

    // Constructor

    // Constructor
    public ViewPagerAdapter(@NonNull FragmentActivity activity, List<String> titles) {
        super(activity);
        this.titles = titles;
    }

    // Returns the number of items (fragments) in ViewPager
    @Override
    public int getItemCount() {
        return titles.size();

    }

    public  int getItem(){
        return examList.size();
    }

    // Creates and returns a fragment for a given position
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString("title", titles.get(position));
        fragment.setArguments(args);
        return fragment;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Model2 examItem = examList.get(position);

        holder.examName.setText(examItem.getName());
        holder.examDate.setText(examItem.getDate());
        holder.examMessage.setText(examItem.getMessage());
        holder.examPic.setImageResource(examItem.getImage1());
        holder.examPic2.setImageResource(examItem.getImage2());
    }


    // ViewHolder class
     class MyViewHolder extends RecyclerView.ViewHolder {
        TextView examName, examDate, examMessage;
        ImageView examPic, examPic2;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            examName = itemView.findViewById(R.id.examName);
            examDate = itemView.findViewById(R.id.examDate);
            examMessage = itemView.findViewById(R.id.examMessage);
            examPic = itemView.findViewById(R.id.examPic);
            examPic2 = itemView.findViewById(R.id.examPic2);
        }
    }
}
