package com.example.belajarmvp1.model;

import java.util.List;

public interface ITodo {
    List<Todo> getTodo();
    void addTodo(Todo todo);
    void removeTodo(String id);

}
