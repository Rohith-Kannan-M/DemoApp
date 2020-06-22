package com.example.demoapp;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragmentone extends Fragment {

    private FragmentoneViewModel mViewModel;
    SwipeRefreshLayout mSwipeRefreshLayout;
    View view;
    ApiInterface apiInterface;
    ArrayList<courses> allcourses = new ArrayList<>();
    PreferenceHelper preferenceHelper;
    String huserid;
    private CourseAdapter courseAdapter;
    private RecyclerView recyclerView;


    public static fragmentone newInstance() {
        return new fragmentone();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmentone_fragment, container, false);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_one);
        preferenceHelper = new PreferenceHelper(getContext());
        huserid = preferenceHelper.getName();
        Log.d("husereid",""+huserid);
        recyclerView = (RecyclerView)view.findViewById(R.id.course_viewf);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        displayCourses();

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                displayCourses();
                new Handler().postDelayed(new Runnable() {
                    @Override public void run() {
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 1000);
            }
        });
        //return inflater.inflate(R.layout.fragmentone_fragment, container, false);
        return view;



    }

    private void displayCourses() {

        apiInterface = ApiClient.getApiClinet().create(ApiInterface.class);
        Call<List<courses>> call = apiInterface.getcourses(huserid);

        call.enqueue(new Callback<List<courses>>() {
            @Override
            public void onResponse(Call<List<courses>> call, Response<List<courses>> response) {
                Log.i("on", "" + response);
                if (!response.isSuccessful()) {
                    Toast.makeText(getActivity(), "" + response.code(), Toast.LENGTH_LONG);
                    return;
                }
                allcourses = new ArrayList<>(response.body());
                if (!allcourses.isEmpty()) {
                    Log.i("myposts", "" + allcourses);
                    courseAdapter = new CourseAdapter(getActivity(), allcourses);
                    courseAdapter.notifyDataSetChanged();
                    recyclerView.setAdapter(courseAdapter);
//

                } else {
                    Log.i("mypa", "" + allcourses);
                    Toast.makeText(getActivity(), "No Customers", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<List<courses>> call, Throwable t) {
                Log.d("throww",call+"/*/"+t);
            }
        });

    }

}
