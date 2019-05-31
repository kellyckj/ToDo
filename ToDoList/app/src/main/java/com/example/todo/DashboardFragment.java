package com.example.todo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DashboardFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
////        final Button button = findViewById(R.id.button3);
////        button.setOnClickListener(new View.OnClickListener() {
////            public void onClick(View v) {
////                // Code here executes on main thread after user presses button
////                startActivity(new Intent(BottomNavigation.this, CreateTask.class));
////            }
////        });
//    }

}
