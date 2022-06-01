package com.example.belajarmvp1.helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.belajarmvp1.R;
import com.example.belajarmvp1.databinding.FragmentTodoItemBinding;
import com.example.belajarmvp1.fragment.FirstFragment;
import com.example.belajarmvp1.model.Todo;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {
    private List<Todo> tes;
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView text_todo;
        public ViewHolder(View itemView) {
            super(itemView);
            text_todo = itemView.findViewById(R.id.text_todo);
        }
    }

    private final int mItemCount;

    public TodoAdapter(List<Todo> items) {
        tes = items;
        mItemCount = items.size();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.fragment_todo_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.text_todo.setText(tes.get(position).getTodo());
    }

    @Override
    public int getItemCount() {
        return mItemCount;
    }



}
