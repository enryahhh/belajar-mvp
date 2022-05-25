package com.example.belajarmvp1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.belajarmvp1.R;
import com.example.belajarmvp1.databinding.FragmentFirstBinding;
import com.example.belajarmvp1.helper.StaticTodos;
import com.example.belajarmvp1.model.Todo;
import com.example.belajarmvp1.presenter.TodoPresenter;
import com.example.belajarmvp1.view.ITodoView;

public class FirstFragment extends Fragment implements ITodoView {

    private FragmentFirstBinding binding;
    TodoPresenter presenter;
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
        presenter = new TodoPresenter(this,new Todo());
        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
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
    public void showTodos() {
        binding.textviewFirst.setText(StaticTodos.todos.get(0).getTodo());
    }
}