package com.example.todo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;


@SuppressLint("SimpleDateFormat")
public class CreateTask extends AppCompatActivity {

    private SimpleDateFormat mFormatter = new SimpleDateFormat("MMMM dd yyyy hh:mm aa");
    private Button button;

    private void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.my_frame,
                fragment).commit();
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
//                button.setText("@string/title_home");
                setFragment(new DashboardFragment());
//                getSupportFragmentManager().beginTransaction().replace(R.id.my_frame,
//                        new DashboardFragment()).commit();
            }
        });
    }








//    private SimpleDateFormat mFormatter = new SimpleDateFormat("MM dd yyyy hh:mm aa");
//    private EditText edittext;
//    private Button mButton;
//
//    private SlideDateTimeListener listener = new SlideDateTimeListener() {
//
//        @Override
//        public void onDateTimeSet(Date date)
//        {
//            mButton.setText("Click Me !");
////            Toast.makeText(CreateTask.this,
////                    mFormatter.format(date), Toast.LENGTH_SHORT).show();
//        }
//
//        // Optional cancel listener
////        @Override
////        public void onDateTimeCancel()
////        {
////            Toast.makeText(CreateTask.this,
////                    "Canceled", Toast.LENGTH_SHORT).show();
////        }
//    };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_create_task);
//
//        edittext = (EditText) findViewById(R.id.date);
//        mButton = (Button) findViewById(R.id.buttona);
//        mButton.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v)
//            {
////                Calendar calendar = Calendar.getInstance();
////                calendar.setTime(new Date());
////                calendar.add(Calendar.MONTH, 1);
////                Date seventhDay = calendar.getTime();
//
//                String mFormatter = "MM dd yyyy hh:mm aa";
//                SimpleDateFormat sdf = new SimpleDateFormat(mFormatter);
////                edittext.setText(sdf.format(calendar.getTime()));
//
//                new SlideDateTimePicker.Builder(getSupportFragmentManager())
//                        .setListener(listener)
//                        .setInitialDate(new Date())
//                        .setMinDate(new Date())
////                        .setMaxDate(seventhDay)
//                        .setIs24HourTime(false)
//                        .setTheme(SlideDateTimePicker.HOLO_DARK)
//                        .setIndicatorColor(Color.parseColor("#990000"))
//                        .build()
//                        .show();
//            }
//        });
//    }






//    final SimpleDateFormat mFormatter = new SimpleDateFormat("MMMM dd yyyy hh:mm aa");
//    //        final Button mButton = (Button) findViewById(R.id.buttona);
//    final EditText edittext = (EditText) findViewById(R.id.date);
//
//    final SlideDateTimeListener listener = new SlideDateTimeListener() {
//
//        @Override
//        public void onDateTimeSet(Date date) {
//            Toast.makeText(CreateTask.this,
//                    mFormatter.format(date), Toast.LENGTH_SHORT).show();
////               updateLabel();
////            edittext.setText(
//
//        }
//
//        // Optional cancel listener
//        @Override
//        public void onDateTimeCancel() {
//            Toast.makeText(CreateTask.this,
//                    "Canceled", Toast.LENGTH_SHORT).show();
//        }
//    };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_create_task);
//
//
////        public boolean onOptionsItemSelected(MenuItem item){
////            Intent myIntent = new Intent(getApplicationContext(), MyActivity.class);
////            startActivityForResult(myIntent, 0);
////            return true;
////        }
//
//        edittext.setOnClickListener(new OnClickListener() {
//            public void onClick(View v) {
//                new SlideDateTimePicker.Builder(getSupportFragmentManager())
//                        .setListener(listener)
//                        .setInitialDate(new Date())
//                        //.setMinDate(minDate)
//                        //.setMaxDate(maxDate)
//                        .setIs24HourTime(true)
//                        //.setTheme(SlideDateTimePicker.HOLO_DARK)
//                        //.setIndicatorColor(Color.parseColor("#990000"))
//                        .build()
//                        .show();
//            }
//        });
//    }






//    private void updateLabel () {
//        String mFormatter = "MM dd yyyy hh:mm aa";
//        SimpleDateFormat sdf = new SimpleDateFormat(mFormatter);
//
//        mButton.setText(sdf.format(calendar.getTime()));
//    }
}
