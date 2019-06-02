package com.example.todo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.support.constraint.Constraints.TAG;

public class DashboardFragment extends Fragment {

    private static final String TAG = DashboardFragment.class.getSimpleName();

    /** The CardView widget. */
    //@VisibleForTesting
    CardView mCardView;

    /**
     * SeekBar that changes the cornerRadius attribute for the {@link #mCardView} widget.
     */
    //@VisibleForTesting
    SeekBar mRadiusSeekBar;

    /**
     * SeekBar that changes the Elevation attribute for the {@link #mCardView} widget.
     */
    //@VisibleForTesting
    SeekBar mElevationSeekBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dashboard, container, false);

        // Read from the database
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        return v;
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment NotificationFragment.
     */
    public static DashboardFragment newInstance() {
        DashboardFragment fragment = new DashboardFragment();
        fragment.setRetainInstance(true);
        return fragment;
    }

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mCardView = (CardView) view.findViewById(R.id.card);
//        mRadiusSeekBar = (SeekBar) view.findViewById(R.id.cardview_radius_seekbar);
//        mRadiusSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                Log.d(TAG, String.format("SeekBar Radius progress : %d", progress));
//                mCardView.setRadius(progress);
//            }
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//                //Do nothing
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//                //Do nothing
//            }
//        });

//        mElevationSeekBar = (SeekBar) view.findViewById(R.id.cardview_elevation_seekbar);
//        mElevationSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                Log.d(TAG, String.format("SeekBar Elevation progress : %d", progress));
//                mCardView.setElevation(progress);
//            }
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//                //Do nothing
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//                //Do nothing
//            }
//        });
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
