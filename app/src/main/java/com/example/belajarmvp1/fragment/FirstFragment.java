package com.example.belajarmvp1.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.belajarmvp1.MainActivity;
import com.example.belajarmvp1.R;
import com.example.belajarmvp1.activity.BottomNavActivity;
import com.example.belajarmvp1.contract.TodoContract;
import com.example.belajarmvp1.databinding.FragmentTodoItemBinding;
import com.example.belajarmvp1.databinding.FragmentFirstBinding;
import com.example.belajarmvp1.helper.CloseDialogListener;
import com.example.belajarmvp1.helper.StaticTodos;
import com.example.belajarmvp1.helper.TodoAdapter;
import com.example.belajarmvp1.model.Todo;
import com.example.belajarmvp1.presenter.TodoPresenter;
import com.example.belajarmvp1.presenter.TodoPresenter2;
import com.example.belajarmvp1.view.ITodoView;

import java.util.List;

public class FirstFragment extends Fragment implements TodoContract.View, CloseDialogListener {

    private FragmentFirstBinding binding;
    private RecyclerView recyclerView;
    private TodoPresenter2 presenter;
    private TodoAdapter adapt;
    String tes;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new TodoPresenter2(this);
        System.out.println("tes tampil todos");
        tes = "asdjasd";
        recyclerView = binding.listTodoItem;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        presenter.loadTodo();
        System.out.println("oncreated");
        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), BottomNavActivity.class);
//                intent.putExtra("TODO",new Todo());
                startActivity(intent);
            }
        });
    }

//    public void handleCloseDialog(){
//        presenter = new TodoPresenter2(this);
//        presenter.loadTodo();
//        Log.i(presenter.toString(),"tesasd");
//        System.out.println("close dialog ff");
//    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("ini onstart");
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("ini on pause");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("ini on resume");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void showMessage() {

    }

    @Override
    public void showTodos(List<Todo> items) {
        adapt = new TodoAdapter(items);
//        recyclerView = recyclerView.findViewById(R.id.list_todo_item);
        recyclerView.setAdapter(adapt);
        adapt.notifyDataSetChanged();
        System.out.println(tes);
        System.out.println(items);
    }



    public void doSomething(){
        System.out.println("wadidawwww");
    }

    @Override
    public void handleDialogClose(DialogInterface dialog) {
        System.out.println("ini saat close dialog");
    }

    @Override
    public void handleDialogCloseList(DialogInterface dialog) {
        System.out.println("close dialog handle mamang");
        presenter.loadTodo();
    }
//    @Override
//    public void showTodos() {
//        binding.textviewFirst.setText(StaticTodos.todos.get(0).getTodo());
//    }
}