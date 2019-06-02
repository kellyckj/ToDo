package com.example.todo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Constants;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.example.todo.CreateTask;
import com.google.firebase.database.core.Context;

import static android.support.constraint.Constraints.TAG;
import static com.example.todo.CreateTask.getUserID;

public class DashboardFragment extends Fragment {

    private View v;
//    View view;
    private RecyclerView mRecView;
//    View_Holder holder;

    private DatabaseReference ContacsRef;
    private FirebaseAuth mAuth;

    List<Task> list;
    List<String> titles;
//    ArrayList<String> titles= new ArrayList<>();
    ArrayList<String> dates= new ArrayList<>();
    ArrayList<String> descriptions= new ArrayList<>();

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_dashboard, container, false);
//        view = LayoutInflater.from(container.getContext()).inflate(R.layout.card_view, container, false);
//        holder = new View_Holder(view);

        mRecView = (RecyclerView) v.findViewById(R.id.rec_view);
        mRecView.setLayoutManager(new LinearLayoutManager(getContext()));

        mAuth = FirebaseAuth.getInstance();

        ContacsRef = FirebaseDatabase.getInstance().getReference().child("Tasks");//.child(getUserID());

        return v;
    }


    @Override
    public void onStart()
    {
        super.onStart();

        FirebaseRecyclerOptions options =
                new FirebaseRecyclerOptions.Builder<Task>()
                        .setQuery(ContacsRef, Task.class)
//                        .orderByChild("due_date")
                        .build();

//        final Recycler_View_Adapter adapter
//                = new Recycler_View_Adapter(options) {
        final FirebaseRecyclerAdapter<Task, View_Holder> adapter
                = new FirebaseRecyclerAdapter<Task, View_Holder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final View_Holder holder, int position, @NonNull Task model)
            {
//                final String userIDs = getRef(position).getKey();
                ContacsRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        if (dataSnapshot.exists()) {
//                            int counter = 0;
                            for (DataSnapshot ds : dataSnapshot.getChildren()) {
//                            if(counter == 2) {//ds.exists()) {
//                                break;
//                            }
//                                Task k = ds.getValue(Task.class);
//                                list.add(k);

                                String t = ds.child("title").getValue(String.class);//.toString();
//                                titles.add(t);
//
//                                TextView stringTextView = (TextView) v.findViewById(R.id.textView);
//////                             stringTextView.getText().toString()
//                                stringTextView.setText(String.valueOf(counter));
//
                                String d = ds.child("due_date").getValue(String.class);//.toString();
//                            dates.add(d);
                                String des = ds.child("description").getValue(String.class);//.toString();
//                            descriptions.add(des);
//
//                            //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
                                holder.title.setText(t);//list.get(position).getTitle());
                                holder.date.setText(d);//list.get(position).getDue_date());
                                holder.description.setText(des);//list.get(position).getDescription());
//
                                Log.d("TAG", t + " / " + d + " / " + des);
//                            list.add(new Task(t,d,des));
//                                counter++;

                            }
//                        }
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }

            @NonNull
            @Override
            public View_Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
            {
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, viewGroup, false);
                View_Holder holder = new View_Holder(view);
//                TextView stringTextView = (TextView) v.findViewById(R.id.textView);
//                stringTextView.setText(String.valueOf(titles.size()));//String.valueOf(i));
//
//                Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
//                holder.title.setText(model.getTitle());//list.get(position).getTitle());
//                holder.date.setText(model.getDue_date());//list.get(position).getDue_date());
//                holder.description.setText(model.getDescription());//list.get(position).getDescription());
//                holder.title.setText(list.get(i).getTitle());
//                holder.date.setText(list.get(i).getDue_date());
//                holder.description.setText(list.get(i).getDescription());
//                holder.title.setText(titles.get(1));
//                holder.date.setText(list.get(i).getDue_date());
//                holder.description.setText(list.get(i).getDescription());
                return holder;
            }
        };

        mRecView.setAdapter(adapter);
        adapter.startListening();
    }
}



































//    private RecyclerView mReView;
//    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("Tasks");//.child(CreateTask.getUserID());
//    List<Task> lstTask;
////    private ListAdapter mListadapter;
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
//                             @Nullable Bundle savedInstanceState) {
//        final View v = inflater.inflate(R.layout.fragment_dashboard, container, false);
//
//        mReView = (RecyclerView) v.findViewById(R.id.rec_view);
////        mTextViewEmpty = (TextView)v.findViewById(R.id.textViewEmpty);
////        mImageViewEmpty = (ImageView)v.findViewById(R.id.imageViewEmpty);
////        mProgressBarLoading = (ProgressBar)v.findViewById(R.id.progressBarLoading);
//
//        Recycler_View_Adapter adapter = new Recycler_View_Adapter(lstTask, getActivity().getApplication());
//        mReView.setAdapter(adapter);
//        mReView.setLayoutManager(new LinearLayoutManager(getActivity().getApplication()));
//
////        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
////        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
////        mReView.setLayoutManager(layoutManager);
//
////        ArrayList data = new ArrayList<Task>();
////        for (int i = 0; i < DataNoteImformation.id.length; i++)
////        {
////            data.add(
////                    new Task
////                            (
////                                    DataNoteImformation.id[i],
////                                    DataNoteImformation.textArray[i],
////                                    DataNoteImformation.dateArray[i]
////                            ));
////        }
//
////        mListadapter = (ListAdapter) new ListAdapter();
////        mReView.setAdapter(mListadapter);
//
////        RecyclerView myrv = (RecyclerView) v.findViewById(R.id.rec_view);
////        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(getContext(),lstTask);
////        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
////        myrv.setLayoutManager(gridLayoutManager);
////        myrv.setAdapter(myAdapter);
//
//        // Read from the database
////        mDatabase.orderByChild("due_date").addValueEventListener(new ValueEventListener() {
////        ValueEventListener eventListener = new ValueEventListener() {
////            @Override
////            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
////                ArrayList<String> titles= new ArrayList<>();
////                ArrayList<String> dates= new ArrayList<>();
////                ArrayList<String> descriptions= new ArrayList<>();
////
////                for(DataSnapshot ds : dataSnapshot.getChildren()) {
////                    String t = ds.child("title").getValue(String.class);
////                    titles.add(t);
////
//////                    TextView stringTextView = (TextView) v.findViewById(R.id.rec_view);
////                    // stringTextView.getText().toString()
//////                    stringTextView.setText(title + " , ");
////
////                    String d = ds.child("due_date").getValue(String.class);
////                    dates.add(d);
////                    String des = ds.child("description").getValue(String.class);
////                    descriptions.add(des);
////
////
////                    Log.d("TAG", t + " / " + d + " / " + des);
////                }
////            }
////
////            @Override
////            public void onCancelled(DatabaseError databaseError) {}
////        };
////
////        mDatabase.addListenerForSingleValueEvent(eventListener);
//
//
//
//
//
//
//        // Read from the database
////        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
////        mDatabase.addValueEventListener(new ValueEventListener() {
////            @Override
////            public void onDataChange(DataSnapshot dataSnapshot) {
////                // This method is called once with the initial value and again
////                // whenever data at this location is updated.
////                String value = dataSnapshot.getValue(String.class);
////                System.out.println("Value is: " + value);
////
////            }
////
////            @Override
////            public void onCancelled(DatabaseError error) {
////                // Failed to read value
////            }
////        });
//
//        return v;
//    }
//
////    /** Use this factory method to create a new instance of
////     * this fragment using the provided parameters.
////     * @return A new instance of fragment NotificationFragment.*/
////    public static DashboardFragment newInstance() {
////        DashboardFragment fragment = new DashboardFragment();
////        fragment.setRetainInstance(true);
////        return fragment;
////    }
////
////    public DashboardFragment() {
////        // Required empty public constructor
////    }
////
//////    @Override
//////    public void onCreate(Bundle savedInstanceState) {
//////        super.onCreate(savedInstanceState);
//////        setContentView(R.layout.fragment_dashboard);
//////
//////
//////    }
////
////    @Override
////    public void onViewCreated(View view, Bundle savedInstanceState) {
////        super.onViewCreated(view, savedInstanceState);
////        mReView = (RecyclerView) view.findViewById(R.id.card);
////    }
//
//}
