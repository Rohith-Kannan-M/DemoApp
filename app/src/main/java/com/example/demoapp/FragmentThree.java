package com.example.demoapp;

import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.ViewModelProviders;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class FragmentThree extends Fragment {

    private FragmentThreeViewModel mViewModel;
    Button  logout;
    PreferenceHelper preferenceHelper;
    ImageView img;

    public static FragmentThree newInstance() {
        return new FragmentThree();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three_fragment, container, false);
        logout = view.findViewById(R.id.logout);
        preferenceHelper = new PreferenceHelper(getContext());
        img = (ImageView)view.findViewById(R.id.pro);
        img.setImageResource(R.drawable.pro);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAlertBox();
            }
        });
        return view;
    }

    private void openAlertBox() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("Are you sure you want to Log out?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //perform any action
                preferenceHelper.putIsLogin(false);
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                getActivity().finish();
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


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FragmentThreeViewModel.class);
        // TODO: Use the ViewModel
    }

}