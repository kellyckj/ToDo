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

    String username = "";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);
        if (getArguments() != null) {
            username = getArguments().getString("username");
        }

        final Button button = v.findViewById(R.id.button2);
        button.setOnClickListener(this);
        return v;
    }


    @Override
    public void onClick(View v) {
        // Code here executes on main thread after user presses button
        startActivityForResult(new Intent(getActivity(), CreateTask.class).putExtra("username",username).
                setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT), 0);
    }
}
