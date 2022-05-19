package com.example.belajarmvp1.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;

import com.example.belajarmvp1.R;
import com.example.belajarmvp1.databinding.FragmentCreateTodoDialogListDialogBinding;
import com.example.belajarmvp1.databinding.FragmentCreateTodoDialogListDialogItemBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//import com.example.belajarmvp1.R;
//import com.example.belajarmvp1.fragment.databinding.FragmentCreateTodoDialogListDialogItemBinding;
//import com.example.belajarmvp1.fragment.databinding.FragmentCreateTodoDialogListDialogBinding;

/**
 * <p>A fragment that shows a list of items as a modal bottom sheet.</p>
 * <p>You can show this modal bottom sheet from your activity like this:</p>
 * <pre>
 *     CreateTodoDialogFragment.newInstance(30).show(getSupportFragmentManager(), "dialog");
 * </pre>
 */
public class CreateTodoDialogFragment extends BottomSheetDialogFragment {

    // TODO: Customize parameter argument names
    private static final String ARG_ITEM_COUNT = "item_count";
    private FragmentCreateTodoDialogListDialogBinding binding;

    // TODO: Customize parameters
    public static CreateTodoDialogFragment newInstance(int itemCount) {
        final CreateTodoDialogFragment fragment = new CreateTodoDialogFragment();
        final Bundle args = new Bundle();
        args.putInt(ARG_ITEM_COUNT, itemCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

//        binding = FragmentCreateTodoDialogListDialogBinding.inflate(inflater, container, false);
//        return binding.getRoot();
        View v = inflater.inflate(R.layout.fragment_create_todo_dialog_list_dialog,
                container, false);

//        Button algo_button = v.findViewById(R.id.algo_button);
        Button save_todo = v.findViewById(R.id.save_todo);

        save_todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getActivity(),
                        "Tambah Todo", Toast.LENGTH_SHORT)
                        .show();
                dismiss();
            }
        });

//        course_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v)
//            {
//                Toast.makeText(getActivity(),
//                        "Course Shared", Toast.LENGTH_SHORT)
//                        .show();
//                dismiss();
//            }
//        });
        return v;

    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        final RecyclerView recyclerView = (RecyclerView) view;
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.setAdapter(new ItemAdapter(getArguments().getInt(ARG_ITEM_COUNT)));
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        final TextView text;

        ViewHolder(FragmentCreateTodoDialogListDialogItemBinding binding) {
            super(binding.getRoot());
            text = binding.text;
        }

    }

    private class ItemAdapter extends RecyclerView.Adapter<ViewHolder> {

        private final int mItemCount;

        ItemAdapter(int itemCount) {
            mItemCount = itemCount;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            return new ViewHolder(FragmentCreateTodoDialogListDialogItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.text.setText(String.valueOf(position));
        }

        @Override
        public int getItemCount() {
            return mItemCount;
        }

    }
}