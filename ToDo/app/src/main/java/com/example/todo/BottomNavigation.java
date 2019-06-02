package com.example.todo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class BottomNavigation extends AppCompatActivity {

    String email;
    Bundle bundle = new Bundle();

    FragmentManager fragmentManager = getSupportFragmentManager();
    Fragment home;
    Fragment dashboard;
    Fragment setting;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            bundle.putString("username", email);
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    home = fragmentManager.findFragmentByTag("HOME");
                    if (home == null) {
                        Fragment flag = new HomeFragment();
                        flag.setArguments(bundle);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                flag, "HOME").addToBackStack("HOME").commit();
                    } else {
                        home.setArguments(bundle);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                home).commit();
                    }
                    return true;
                case R.id.navigation_dashboard:
                    dashboard = fragmentManager.findFragmentByTag("DASHBOARD");
                    if (dashboard == null) {
                        Fragment flag = new DashboardFragment();
                        flag.setArguments(bundle);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                flag, "DASHBOARD").addToBackStack("DASHBOARD").commit();
                    } else {
                        dashboard.setArguments(bundle);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                dashboard).commit();
                    }
                    return true;
                case R.id.navigation_setting:
                    setting = fragmentManager.findFragmentByTag("SETTING");
                    if (setting == null) {
                        Fragment flag = new SettingFragment();
                        flag.setArguments(bundle);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                flag, "SETTING").addToBackStack("SETTING").commit();
                    } else {
                        setting.setArguments(bundle);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                setting).commit();
                    }
                    return true;
            }
            return false;
        }

//        private void setFragment(Fragment fragment) {
////            fragment.setArguments(bundle);
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                    fragment).commit();
//        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        Bundle extras = getIntent().getExtras();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        /* save user email address */
        if (extras != null && extras.containsKey("username")) {
            email = extras.getString("username");
        }

        home = fragmentManager.findFragmentByTag("HOME");
        if (home == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment(), "HOME").addToBackStack("HOME").commit();
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    home).commit();
        }
    }
}
