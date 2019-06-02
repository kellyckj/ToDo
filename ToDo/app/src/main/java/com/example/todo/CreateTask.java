package com.example.todo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


@SuppressLint("SimpleDateFormat")
public class CreateTask extends AppCompatActivity {

//    private SimpleDateFormat mFormatter = new SimpleDateFormat("MMMM dd yyyy hh:mm aa");
    private Button button;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    static String mGroupId;

    public boolean writeNewTask(String title, String due_date, String description) {
        Task task = new Task(title, due_date, description);
        final boolean[] flag = new boolean[1];
        if (title == "" || due_date == "")
            return false;
//        mGroupId = mDatabase.child("Tasks").push().getKey();
//        mDatabase.child(mGroupId).setValue(task);
        mDatabase = mDatabase.child("Tasks").push();
        mGroupId = mDatabase.getKey();
        mDatabase.setValue(task);
        return true;
    }

    public static String getUserID() {
        return mGroupId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        button = (Button) findViewById(R.id.submit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText) findViewById(R.id.task_name);
                EditText due_date = (EditText) findViewById(R.id.date);
                EditText desc = (EditText) findViewById(R.id.description_text);
                String title = name.getText().toString();
                String date = due_date.getText().toString();
                String description = desc.getText().toString();

                //make it so it saves under the user ID
//                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//                String id = user.getUid();

                boolean ret = writeNewTask(title, date, description);

//                Task task = new Task(title, date, description);
//                mDatabase.child("tasks").setValue(task);


//                mDatabase = mDatabase.child("task");
//                mDatabase.child("description").setValue(description);
//                mDatabase.child("due date").setValue(date);
//                mDatabase.child("title").setValue(title);

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


}
