package com.example.belajarmvp1.fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;

import com.example.belajarmvp1.MainActivity;
import com.example.belajarmvp1.R;
import com.example.belajarmvp1.contract.TodoContract;
import com.example.belajarmvp1.databinding.FragmentCreateTodoDialogListDialogBinding;
import com.example.belajarmvp1.databinding.FragmentTodoItemBinding;
import com.example.belajarmvp1.helper.CloseDialogListener;
import com.example.belajarmvp1.helper.TodoAdapter;
import com.example.belajarmvp1.model.Todo;
import com.example.belajarmvp1.presenter.TodoPresenter;
import com.example.belajarmvp1.presenter.TodoPresenter2;
import com.example.belajarmvp1.view.ITodoView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
public class CreateTodoDialogFragment extends BottomSheetDialogFragment implements TodoContract.View {

    // TODO: Customize parameter argument names
    private static final String ARG_ITEM_COUNT = "item_count";
    private FragmentCreateTodoDialogListDialogBinding binding;
    private TodoPresenter2 presenter;
    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    FirstFragment fragmentf;

    // TODO: Customize parameters
    public static CreateTodoDialogFragment newInstance(int itemCount) {
        final CreateTodoDialogFragment fragment = new CreateTodoDialogFragment();
        final Bundle args = new Bundle();
        args.putInt(ARG_ITEM_COUNT, itemCount);
        fragment.setArguments(args);
        return fragment;
    }

    public interface CreateTodoDialogListener {
        void onFinishTodoDialog();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//        binding = FragmentCreateTodoDialogListDialogBinding.inflate(inflater, container, false);
//        return binding.getRoot();
        fragmentManager = getActivity().getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
         fragmentf =
                (FirstFragment) fragmentManager.findFragmentById(R.id.ff);
//
//        presenter = (TodoPresenter2) fragmentf.presenter;
        presenter = new TodoPresenter2(this);
        View v = inflater.inflate(R.layout.fragment_create_todo_dialog_list_dialog,
                container, false);
        EditText todoText = v.findViewById(R.id.todoText);
//        Button algo_button = v.findViewById(R.id.algo_button);
        Button save_todo = v.findViewById(R.id.save_todo);

                save_todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                presenter.onSaveTodo(new Todo(UUID.randomUUID().toString(),todoText.getText().toString()));
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
        System.out.println("dialog destroyed");
    }

    @Override
    public void showMessage() {
        System.out.println("show message");
    }

    @Override
    public void showTodos(List<Todo> items) {
//        transaction.replace(R.id.ff,FirstFragment.class,null).setReorderingAllowed(true);
//        transaction.attach(fragmentf).detach(fragmentf);
//        transaction.commit();
//        TodoAdapter adapt = new TodoAdapter(items);
//        adapt.notifyDataSetChanged();
//        System.out.println("berhasil");
//        System.out.println();
    }

    @Override
    public void handleDialogClose(DialogInterface dialog) {

    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        MainActivity activity = (MainActivity) getActivity();
        if(activity instanceof CloseDialogListener)
            ((CloseDialogListener)activity).handleDialogCloseList(dialog);
    }

    //    private class ViewHolder extends RecyclerView.ViewHolder {
//
//        final TextView text;
//
//        ViewHolder(FragmentCreateTodoDialogListDialogItemBinding binding) {
//            super(binding.getRoot());
//            text = binding.text;
//        }
//
//    }
//
//    private class ItemAdapter extends RecyclerView.Adapter<ViewHolder> {
//
//        private final int mItemCount;
//
//        ItemAdapter(int itemCount) {
//            mItemCount = itemCount;
//        }
//
//        @NonNull
//        @Override
//        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//            return new ViewHolder(FragmentCreateTodoDialogListDialogItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
//
//        }
//
//        @Override
//        public void onBindViewHolder(ViewHolder holder, int position) {
//            holder.text.setText(String.valueOf(position));
//        }
//
//        @Override
//        public int getItemCount() {
//            return mItemCount;
//        }
//
//    }
}