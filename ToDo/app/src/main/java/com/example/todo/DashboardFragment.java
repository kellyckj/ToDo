package com.example.todo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DashboardFragment extends Fragment {

    private View v;
    private RecyclerView mRecView;

    private DatabaseReference ContacsRef;
    private FirebaseAuth mAuth;

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_dashboard, container, false);

        mRecView = (RecyclerView) v.findViewById(R.id.rec_view);
        mRecView.setLayoutManager(new LinearLayoutManager(getContext()));

        mAuth = FirebaseAuth.getInstance();

        String username = "";
        if (getArguments() != null) {
            username = getArguments().getString("username");
        }
        ContacsRef = FirebaseDatabase.getInstance().getReference().child(username);//.child(getUserID());

        return v;
    }


    @Override
    public void onStart()
    {
        super.onStart();

        FirebaseRecyclerOptions options =
                new FirebaseRecyclerOptions.Builder<Task>()
                        .setQuery(ContacsRef, Task.class)
                        .build();

        final FirebaseRecyclerAdapter<Task, View_Holder> adapter
                = new FirebaseRecyclerAdapter<Task, View_Holder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final View_Holder holder, int position, @NonNull Task model)
            {
                ContacsRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                String t = ds.child("title").getValue(String.class);//.toString();
                                String d = ds.child("due_date").getValue(String.class);//.toString();
                                String des = ds.child("description").getValue(String.class);//.toString();

                            //  Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
                                holder.title.setText(t);//list.get(position).getTitle());
                                holder.date.setText(d);//list.get(position).getDue_date());
                                holder.description.setText(des);//list.get(position).getDescription());

                                Log.d("TAG", t + " / " + d + " / " + des);
                            }
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
                return holder;
            }
        };

        mRecView.setAdapter(adapter);
        adapter.startListening();
    }
}