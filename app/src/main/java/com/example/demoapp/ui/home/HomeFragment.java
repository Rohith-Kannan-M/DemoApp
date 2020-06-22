package com.example.demoapp.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.demoapp.ApiClient;
import com.example.demoapp.ApiInterface;
import com.example.demoapp.CourseAdapter;
import com.example.demoapp.FragmentoneViewModel;
import com.example.demoapp.PreferenceHelper;
import com.example.demoapp.R;
import com.example.demoapp.courses;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentoneViewModel mViewModel;
    SwipeRefreshLayout mSwipeRefreshLayout;
    ApiInterface apiInterface;
    ArrayList<courses> allcourses = new ArrayList<>();
    PreferenceHelper preferenceHelper;
    String huserid;
    private CourseAdapter courseAdapter;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);
        /*homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        mSwipeRefreshLayout = (SwipeRefreshLayout) root.findViewById(R.id.swipe_one);

        return root;
    }
}
