package com.example.belajarmvp1.model;

import java.util.Date;

public interface ITodo {
    void getTodo();
    void addTodo(Todo todo);
    void removeTodo(String id);

}
