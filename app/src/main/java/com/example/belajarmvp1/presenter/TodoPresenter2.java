package com.example.belajarmvp1.presenter;

import android.content.DialogInterface;

import com.example.belajarmvp1.contract.TodoContract;
import com.example.belajarmvp1.interactor.TodoInteractor;
import com.example.belajarmvp1.model.Todo;

import java.util.List;

public class TodoPresenter2 implements TodoContract.Presenter {

    private TodoInteractor todoInteractor = new TodoInteractor();
    private TodoContract.View view_c;
    public TodoPresenter2(TodoContract.View view){
        view_c = view;
    }
    @Override
    public void onSaveTodo(Todo todo) {
        todoInteractor.addTodo(todo);
        view_c.showTodos(todoInteractor.getTodos());
        view_c.showMessage();
    }

    @Override
    public void loadTodo() {
        view_c.showTodos(todoInteractor.getTodos());
    }

}
