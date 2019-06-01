package com.example.todo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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
        startActivity(new Intent(getActivity(), CreateTask.class));
    }

}
