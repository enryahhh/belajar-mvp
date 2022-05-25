package com.example.belajarmvp1.presenter;

import android.util.Log;

import com.example.belajarmvp1.helper.StaticTodos;
import com.example.belajarmvp1.model.ITodo;
import com.example.belajarmvp1.model.Todo;
import com.example.belajarmvp1.view.ITodoView;

import java.util.List;
import java.util.UUID;

public class TodoPresenter implements ITodoPresenter{
    private ITodo itodo;
    private ITodoView viewTodo;
//    private List<Todo> todos = StaticTodos.todos;
    public TodoPresenter(ITodoView viewTodo ,ITodo itodo){
        this.itodo = itodo;
        this.viewTodo = viewTodo;
    }

    @Override
    public void onSaveTodo(String todo) {
        String id = String.valueOf(UUID.randomUUID());
        Todo todoObj = new Todo(id,todo);
//        todoObj.setTodo(id,todo);
//        StaticTodos.todos.add(todoObj);
        itodo.addTodo(todoObj);
//        System.out.println(todo);
        itodo.getTodos();
        System.out.println(StaticTodos.todos.toString());
        viewTodo.showMessage();
        viewTodo.showTodos();
    }

    @Override
    public void onStart() {
//        itodo = new Todo();
        itodo.getTodos();
        Log.i("debug",StaticTodos.todos.toString());
    }

    @Override
    public void onDeleteTodo() {

    }

    @Override
    public void onDestroy() {

    }
}
