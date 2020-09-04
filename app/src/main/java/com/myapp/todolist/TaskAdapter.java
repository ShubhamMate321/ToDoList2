package com.myapp.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    ArrayList<Task> taskArrayList;
    public TaskAdapter(ArrayList<Task> taskArrayList) {
        this.taskArrayList = taskArrayList;
    }


    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_task,parent,false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        final Task o = taskArrayList.get(position);
        holder.tvTitle.setText(o.getTitle());
        holder.tvDescription.setText(o.getDescription());
        holder.tvPriority.setText(o.getPriority());
        holder.tvTag.setText(o.getTag());
    }

    @Override
    public int getItemCount() {
        return taskArrayList.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle,tvDescription,tvPriority,tvTag;
        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvPriority = itemView.findViewById(R.id.tvPriority);
            tvTag = itemView.findViewById(R.id.tvTag);
        }
    }
}
