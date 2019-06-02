package com.example.todo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Constants;

import java.util.ArrayList;
import java.util.List;

import com.example.todo.CreateTask;
import com.google.firebase.database.core.Context;

import static android.support.constraint.Constraints.TAG;

public class DashboardFragment extends Fragment {

    private RecyclerView mReView;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("Tasks");//.child(CreateTask.getUserID());
    List<Task> lstTask;
//    private ListAdapter mListadapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_dashboard, container, false);

        mReView = (RecyclerView) v.findViewById(R.id.rec_view);
//        mTextViewEmpty = (TextView)v.findViewById(R.id.textViewEmpty);
//        mImageViewEmpty = (ImageView)v.findViewById(R.id.imageViewEmpty);
//        mProgressBarLoading = (ProgressBar)v.findViewById(R.id.progressBarLoading);

        Recycler_View_Adapter adapter = new Recycler_View_Adapter(lstTask, getActivity().getApplication());
        mReView.setAdapter(adapter);
        mReView.setLayoutManager(new LinearLayoutManager(getActivity().getApplication()));

//        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        mReView.setLayoutManager(layoutManager);

//        ArrayList data = new ArrayList<Task>();
//        for (int i = 0; i < DataNoteImformation.id.length; i++)
//        {
//            data.add(
//                    new Task
//                            (
//                                    DataNoteImformation.id[i],
//                                    DataNoteImformation.textArray[i],
//                                    DataNoteImformation.dateArray[i]
//                            ));
//        }

//        mListadapter = (ListAdapter) new ListAdapter();
//        mReView.setAdapter(mListadapter);

//        RecyclerView myrv = (RecyclerView) v.findViewById(R.id.rec_view);
//        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(getContext(),lstTask);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
//        myrv.setLayoutManager(gridLayoutManager);
//        myrv.setAdapter(myAdapter);

        // Read from the database
//        mDatabase.orderByChild("due_date").addValueEventListener(new ValueEventListener() {
//        ValueEventListener eventListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                ArrayList<String> titles= new ArrayList<>();
//                ArrayList<String> dates= new ArrayList<>();
//                ArrayList<String> descriptions= new ArrayList<>();
//
//                for(DataSnapshot ds : dataSnapshot.getChildren()) {
//                    String t = ds.child("title").getValue(String.class);
//                    titles.add(t);
//
////                    TextView stringTextView = (TextView) v.findViewById(R.id.rec_view);
//                    // stringTextView.getText().toString()
////                    stringTextView.setText(title + " , ");
//
//                    String d = ds.child("due_date").getValue(String.class);
//                    dates.add(d);
//                    String des = ds.child("description").getValue(String.class);
//                    descriptions.add(des);
//
//
//                    Log.d("TAG", t + " / " + d + " / " + des);
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {}
//        };
//
//        mDatabase.addListenerForSingleValueEvent(eventListener);






        // Read from the database
//        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
//        mDatabase.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.class);
//                System.out.println("Value is: " + value);
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//            }
//        });

        return v;
    }

//    /** Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     * @return A new instance of fragment NotificationFragment.*/
//    public static DashboardFragment newInstance() {
//        DashboardFragment fragment = new DashboardFragment();
//        fragment.setRetainInstance(true);
//        return fragment;
//    }
//
//    public DashboardFragment() {
//        // Required empty public constructor
//    }
//
////    @Override
////    public void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.fragment_dashboard);
////
////
////    }
//
//    @Override
//    public void onViewCreated(View view, Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        mReView = (RecyclerView) view.findViewById(R.id.card);
//    }

}
