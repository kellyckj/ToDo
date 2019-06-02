package com.example.todo;

import android.app.ListActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public abstract class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>
{
    private ArrayList<Task> dataList;

    public ListAdapter(ArrayList<Task> data)
    {
        this.dataList = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView task_name;
        TextView date;
        TextView description_text;

        public ViewHolder(View itemView)
        {
            super(itemView);
            this.task_name = (TextView) itemView.findViewById(R.id.task_name);
            this.date = (TextView) itemView.findViewById(R.id.date);
            this.description_text = (TextView) itemView.findViewById(R.id.description_text);
        }
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_dashboard, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

//    @Override
//    public void onBindViewHolder(ListAdapter.ViewHolder holder, final int position)
//    {
//        holder.task_name.setText(dataList.get(position).getTitle());
//        holder.date.setText(dataList.get(position).getDue_date());
//        holder.description_text.setText(dataList.get(position).getDescription());
//
//        holder.itemView.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                Toast.makeText(ListAdapter.this, "Item " + position + " is clicked.", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    @Override
    public int getItemCount()
    {
        return dataList.size();
    }
}

