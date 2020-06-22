package com.example.demoapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyCourseAdpater extends RecyclerView.Adapter<MyCourseAdpater.ViewHolder> {
    private ArrayList<MyCourses> mycourses = new ArrayList<>();
    private Context context;


    public MyCourseAdpater(Context context, ArrayList<MyCourses> mycourses) {
        this.mycourses = mycourses;
        this.context = context;
    }

    @NonNull
    @Override
    public MyCourseAdpater.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mycourse_list,viewGroup,false);
        return new MyCourseAdpater.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCourseAdpater.ViewHolder viewHolder, int i) {
        viewHolder.coursename2.setText(mycourses.get(i).getCoursename());
        viewHolder.duration2.setText(mycourses.get(i).getDuration()+" weeks");
        viewHolder.tutor2.setText("By "+mycourses.get(i).getTutor());
        Picasso.get().load(mycourses.get(i).getCoursepic()).into(viewHolder.imageView2);
    }

    @Override
    public int getItemCount() {
        return mycourses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView coursename2,duration2,tutor2;
        private ImageView imageView2;
        private CardView cv2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            coursename2 = (TextView)itemView.findViewById(R.id.f_coursename2);
            duration2 = (TextView)itemView.findViewById(R.id.f_duration2);
            tutor2 = (TextView)itemView.findViewById(R.id.f_tutor2);
            imageView2 = (ImageView)itemView.findViewById(R.id.f_coursepic2);
            cv2 = (CardView)itemView.findViewById(R.id.carda2);

        }
    }
}

