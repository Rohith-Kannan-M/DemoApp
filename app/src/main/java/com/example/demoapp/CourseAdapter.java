package com.example.demoapp;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.demoapp.MainActivity.staticuserid;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    private ArrayList<courses> allcourses = new ArrayList<>();
    private Context context;
    Dialog myDialog;
    PreferenceHelper preferenceHelper;


    public CourseAdapter(Context context, ArrayList<courses> allcourses){
        this.allcourses=allcourses;
        this.context=context;

    }

    @NonNull
    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fullcourse_list,viewGroup,false);
        return new CourseAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.ViewHolder viewHolder, int i) {
        viewHolder.coursename.setText(allcourses.get(i).getCoursename());
        viewHolder.duration.setText(allcourses.get(i).getDuration()+" weeeks");
        viewHolder.tutor.setText("By "+allcourses.get(i).getTutor());
        viewHolder.price.setText("₹"+allcourses.get(i).getPrice());
        Picasso.get().load(allcourses.get(i).getCoursepic()).into(viewHolder.imageView);
        preferenceHelper = new PreferenceHelper(context);

        viewHolder.buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String courseid= allcourses.get(i).getCourseid();
                //Log.d("usa",staticuserid+""+userid);
                String userid= preferenceHelper.getName();
                Log.d("usa",""+userid);
                openAlertBox(courseid,userid);
            }
        });

        viewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog = new Dialog(context);
                myDialog.setContentView(R.layout.dialog);
                TextView name = (TextView) myDialog.findViewById(R.id.course_name_d);
                TextView tutor = (TextView) myDialog.findViewById(R.id.tutor_d);
                TextView duration = (TextView) myDialog.findViewById(R.id.duration_d);
                TextView price = (TextView) myDialog.findViewById(R.id.price_d);
                ImageView iv = (ImageView)myDialog.findViewById(R.id.course_pic_d);

                Picasso.get().load(allcourses.get(i).getCoursepic()).into(iv);
                name.setText("This is "+allcourses.get(i).getCoursename()+" course");
                tutor.setText("The Tutor is "+allcourses.get(i).getTutor());
                duration.setText("The duration is "+allcourses.get(i).getDuration()+" weeks");
                price.setText("₹"+allcourses.get(i).getPrice());

                myDialog.show();



            }
        });

    }

    private void openAlertBox(String courseid, String userid) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Are you sure you want to buy this course?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //perform any action
                String course_id=courseid;
                String user_id=userid;
                Log.i("cuu",""+course_id);
                Log.i("uuu",""+user_id);
                buyCourse(course_id,user_id);
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //perform any action
                dialog.cancel();
            }
        });

        AlertDialog alert11 = builder.create();
        alert11.show();

    }

    private void buyCourse(String course_id, String user_id) {
        ApiInterface apiInterface = ApiClient.getApiClinet().create(ApiInterface.class);
        Log.d("par",course_id+"***"+user_id);
        Call<String> call = apiInterface.getCourseRegi(user_id,course_id);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.i("r-onSuccess", response.body().toString());

                        String jsonresponse = response.body().toString();
                        try {
                            parseRegData(jsonresponse);
                        } catch (JSONException e) {
                            Log.i("error",""+e);
                            e.printStackTrace();
                        }
                    } else {
                        Log.i("onEmptyResponse", "Returned empty response");//Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i("failure",""+call+"\n"+t);
            }
        });
    }


        private void parseRegData(String response) throws JSONException {

            Log.i("response",""+response);
            JSONObject jsonObject = new JSONObject(response);
            Log.d("check",""+jsonObject.optString("status"));
            if (jsonObject.optString("status").equals("true")){

                Dialog newdialog = new Dialog(context);
                newdialog.setContentView(R.layout.dialog_buy);
                ImageView ev = (ImageView)newdialog.findViewById(R.id.ev);
                ev.setImageResource(R.drawable.tick);
                newdialog.show();



            }else {

                Toast.makeText(context, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
            }
        }



    @Override
    public int getItemCount() {
        return allcourses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView coursename,duration,tutor,price;
        private Button buy;
        private ImageView imageView;
        private CardView cv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            coursename = (TextView)itemView.findViewById(R.id.f_coursename);
            duration = (TextView)itemView.findViewById(R.id.f_duration);
            tutor = (TextView)itemView.findViewById(R.id.f_tutor);
            price = (TextView)itemView.findViewById(R.id.f_price);
            buy = (Button)itemView.findViewById(R.id.f_buy);
            imageView = (ImageView)itemView.findViewById(R.id.f_coursepic);
            cv = (CardView)itemView.findViewById(R.id.carda);

        }
    }
}
