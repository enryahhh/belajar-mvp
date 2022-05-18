package com.example.belajarmvp1.presenter;

import com.example.belajarmvp1.model.ITodo;
import com.example.belajarmvp1.model.Todo;
import com.example.belajarmvp1.view.ITodoView;

import java.util.UUID;

public class TodoPresenter implements ITodoPresenter{
    private ITodo iTodo;
    private ITodoView viewTodo;

    public TodoPresenter(ITodoView viewTodo, ITodo itodo){
        this.iTodo = itodo;
        this.viewTodo = viewTodo;
    }

    @Override
    public void onSaveTodo(String todo) {
        String id = String.valueOf(UUID.randomUUID());
        Todo todoObj = new Todo(id,todo);
        iTodo.addTodo(todoObj);
    }

    @Override
    public void onDeleteTodo() {

    }

    @Override
    public void onDestroy() {

    }
}
