package com.example.belajarmvp1.presenter;

import android.util.Log;

import com.example.belajarmvp1.model.ITodo;
import com.example.belajarmvp1.model.Todo;
import com.example.belajarmvp1.view.ITodoView;

import java.util.List;
import java.util.UUID;

public class TodoPresenter implements ITodoPresenter{
    private ITodo itodo;
    private ITodoView viewTodo;
//    private List<Todo> todos = new ArrayList<Todo>();
    public TodoPresenter(ITodoView viewTodo ,ITodo itodo){
        this.itodo = itodo;
        this.viewTodo = viewTodo;
    }

    @Override
    public void onSaveTodo(String todo) {
        String id = String.valueOf(UUID.randomUUID());
        Todo todoObj = new Todo(id,todo);
//        todoObj.setTodo(id,todo);
        itodo.addTodo(todoObj);
//        System.out.println(todo);
        itodo.getTodo();
        System.out.println(itodo.getTodo().toString());
    }

    @Override
    public void onStart() {
//        itodo = new Todo();
        itodo.getTodo();
        List<Todo> tes = itodo.getTodo();
        Log.i("debug",tes.toString());
    }

    @Override
    public void onDeleteTodo() {

    }

    @Override
    public void onDestroy() {

    }
}
