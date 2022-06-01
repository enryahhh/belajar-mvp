package com.example.belajarmvp1.contract;

import com.example.belajarmvp1.model.Todo;

import java.util.List;

public interface TodoContract {
    interface View {
        void showMessage();
        void showTodos(List<Todo> items);
    }

    interface Interactor{
        List<Todo> getTodos();
        void addTodo(Todo todo);
        Integer countTodo();
    }

    interface Presenter{
        void onSaveTodo(Todo todo);
        void loadTodo();
    }
}
