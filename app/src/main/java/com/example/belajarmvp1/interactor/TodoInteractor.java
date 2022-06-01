package com.example.belajarmvp1.interactor;

import androidx.lifecycle.MutableLiveData;

import com.example.belajarmvp1.contract.TodoContract;
import com.example.belajarmvp1.helper.StaticTodos;
import com.example.belajarmvp1.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoInteractor implements TodoContract.Interactor {
    private List<Todo> todos = StaticTodos.todos;
//    private MutableLiveData<List<Todo>>  tes = new MutableLiveData<List<Todo>>();
    @Override
    public List<Todo> getTodos() {
        return todos;
    }

    @Override
    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    @Override
    public Integer countTodo() {
        return todos.size();
    }
}
