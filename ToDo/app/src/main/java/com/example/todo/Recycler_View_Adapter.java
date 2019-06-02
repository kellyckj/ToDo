package com.example.todo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recycler_View_Adapter extends RecyclerView.Adapter<View_Holder> {

    List<Task> list;
    Context context;
    View v;

    public Recycler_View_Adapter(List<Task> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_dashboard, parent, false);
        View_Holder holder = new View_Holder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(final View_Holder holder, final int position) {

//        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("Tasks");
//
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
//                    Log.d("TAG", t + " / " + d + " / " + des);
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {}
//        };
//        mDatabase.addListenerForSingleValueEvent(eventListener);

        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        holder.title.setText("hello");//list.get(position).getTitle());
        holder.date.setText("today");//list.get(position).getDue_date());
        holder.description.setText("stress");//list.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        //returns the number of elements the RecyclerView will display
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, Task task) {
        list.add(position, task);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(Task tasl) {
        int position = list.indexOf(tasl);
        list.remove(position);
        notifyItemRemoved(position);
    }

}