package com.example.todo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class StartDashboard extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(android.R.id.content, new DashboardFragment()).commit();}
//    }

}
