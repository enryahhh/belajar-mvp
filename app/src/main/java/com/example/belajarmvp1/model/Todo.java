package com.example.belajarmvp1.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Todo implements ITodo{
    private String id;
    private String todo;
    private boolean isDone;
    private Date tgl;

    private List<Todo> todos = new ArrayList<Todo>();

    public Todo(String id, String todo){
        this.id = id;
        this.todo = todo;
        this.isDone = false;
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        this.tgl = today.getTime();
    }


    @Override
    public void getTodo() {

    }

    @Override
    public void addTodo(Todo todo) {
        this.todos.add(todo);
    }

    @Override
    public void removeTodo(String id) {

    }
}
