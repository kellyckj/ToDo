package com.example.todo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;


@SuppressLint("SimpleDateFormat")
public class CreateTask extends AppCompatActivity {

    private SimpleDateFormat mFormatter = new SimpleDateFormat("MMMM dd yyyy hh:mm aa");
    private Button button;

    private DatabaseReference mDatabase;
    mDatabase = FirebaseDatabase.getInstance().getReference();

//    private void setFragment(Fragment fragment) {
//        getSupportFragmentManager().beginTransaction().add(R.id.my_frame,
//                fragment).commit();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_task);

        button = (Button) findViewById(R.id.submit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateTask.this,BottomNavigation.class).
                        setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                intent.putExtra("flag",true);
                finish();
//                finishActivity(0);
//                startActivity(intent);
//                Fragment fragment = new DashboardFragment();
//                startActivity(new Intent(CreateTask.this, StartDashboard.class));

//                button.setText("@string/title_home");
//                setFragment(new DashboardFragment());
//                getSupportFragmentManager().beginTransaction().replace(R.id.my_frame,
//                        new DashboardFragment()).commit();
            }
        });
    }

    public class Task {

        public String title;
        public String due_date;
        public String description;

        public Task() {
            // Default constructor required for calls to DataSnapshot.getValue(User.class)
            title = "";
            due_date = "";
            description = "";
        }

        public Task(String title, String due_date, String description) {
            this.title = title;
            this.due_date = due_date;
            this.description = description;
        }
    }

}
