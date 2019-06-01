package com.example.todo;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static android.app.Activity.RESULT_OK;

public class HomeFragment extends Fragment implements View.OnClickListener{

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);

        final Button button = v.findViewById(R.id.button2);
        button.setOnClickListener(this);
        return v;
    }


    @Override
    public void onClick(View v) {
        // Code here executes on main thread after user presses button
        startActivityForResult(new Intent(getActivity(), CreateTask.class), 0);
    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == 0 && resultCode == RESULT_OK) {
////            int latitude = data.getIntExtra("latitude", 0);
////            int longitude = data.getIntExtra("longitude", 0);
////            // do something with B's return values
//
//            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//            fragmentManager.popBackStack ("SETTING", FragmentManager.POP_BACK_STACK_INCLUSIVE);
//
////            FragmentManager fragmentManager = getSupportFragmentManager();
////            dashboard = fragmentManager.findFragmentByTag("DASHBOARD");
////            if (dashboard == null) {
////                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
////                        new DashboardFragment(), "DASHBOARD").addToBackStack("DASHBOARD").commit();
////            } else {
////                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
////                        dashboard).commit();
////            }
//        }
//    }
}
