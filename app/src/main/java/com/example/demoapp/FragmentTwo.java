package com.example.demoapp;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

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
import rx.internal.operators.CompletableOnSubscribeConcat;

public class FragmentTwo extends Fragment {

    private FragmentTwoViewModel mViewModel;
    SwipeRefreshLayout mSwipeRefreshLayout;
    View view;
    ApiInterface apiInterface;
    ArrayList<MyCourses> mycourses = new ArrayList<>();
    PreferenceHelper preferenceHelper;
    String huserid;
    private MyCourseAdpater myCourseAdpater;
    private RecyclerView recyclerView;
    Context hcontext;

    public static FragmentTwo newInstance() {
        return new FragmentTwo();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_two_fragment, container, false);
        preferenceHelper = new PreferenceHelper(getContext());
        huserid = preferenceHelper.getName();
        Log.d("iusereid",""+huserid);
        recyclerView = (RecyclerView)view.findViewById(R.id.mycourse_viewf);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        displayMycourses();
        return  view;
    }

    private void displayMycourses() {
        apiInterface = ApiClient.getApiClinet().create(ApiInterface.class);
        Call<List<MyCourses>> call = apiInterface.getMycourses(huserid);
        call.enqueue(new Callback<List<MyCourses>>() {
            @Override
            public void onResponse(Call<List<MyCourses>> call, Response<List<MyCourses>> response) {
                Log.i("on", "" + response);
                if (!response.isSuccessful()) {
                    Toast.makeText(getActivity(), "" + response.code(), Toast.LENGTH_LONG);
                    return;
                }
                mycourses = new ArrayList<>(response.body());
                if (!mycourses.isEmpty()) {
                    Log.i("myposts", "" + mycourses);
                    myCourseAdpater = new MyCourseAdpater(getActivity(),mycourses);
                    myCourseAdpater.notifyDataSetChanged();
                    recyclerView.setAdapter(myCourseAdpater);
//

                } else {
                    Log.i("mypa", "" + mycourses);
                    Toast.makeText(getActivity(), "No Customers", Toast.LENGTH_LONG).show();
                }

            }
            @Override
            public void onFailure(Call<List<MyCourses>> call, Throwable t) {
                Log.d("throww",call+"/*/"+t);
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FragmentTwoViewModel.class);
        // TODO: Use the ViewModel
    }

}