package com.example.todo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.content.Intent;

public class BottomNavigation extends AppCompatActivity {

    String email;
    Bundle bundle = new Bundle();

    FragmentManager fragmentManager = getSupportFragmentManager();
    Fragment home;
    Fragment dashboard;
    Fragment setting;
//    home = fragmentManager.findFragmentByTag("HOME");
//    dashboard = fragmentManager.findFragmentByTag("DASHBOARD");
//    setting = fragmentManager.findFragmentByTag("SETTING");

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
                    home = fragmentManager.findFragmentByTag("HOME");
                    if (home == null) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new HomeFragment(), "HOME").addToBackStack("HOME").commit();
                    } else {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                home).commit();
                    }
                    return true;
                case R.id.navigation_dashboard:
//                    mTextMessage.setText(R.string.title_dashboard);
                    dashboard = fragmentManager.findFragmentByTag("DASHBOARD");
                    if (dashboard == null) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new DashboardFragment(), "DASHBOARD").addToBackStack("DASHBOARD").commit();
                    } else {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                dashboard).commit();
                    }
                    return true;
                case R.id.navigation_setting:
//                    mTextMessage.setText(R.string.title_setting);
                    setting = fragmentManager.findFragmentByTag("SETTING");
                    bundle.putString("username", email);
                    if (setting == null) {
                        Fragment frag = new SettingFragment();
                        frag.setArguments(bundle);
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                frag, "SETTING").addToBackStack("SETTING").commit();
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

        /* if just created a new task, jump to dashboard */
        if (extras != null && extras.containsKey("flag")) {
//            boolean flag= extras.getBoolean("flag");
            if (extras.getBoolean("flag")) {
//                R.id.fragment_container = DashboardFragment().getId();
                dashboard = fragmentManager.findFragmentByTag("DASHBOARD");
                if (dashboard == null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new DashboardFragment(), "DASHBOARD").addToBackStack("DASHBOARD").commit();
                } else {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            dashboard).commit();
                }
                navigation.setSelectedItemId(R.id.navigation_dashboard);
            }
        }
        /* if new, go to home */
        else {
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
}
