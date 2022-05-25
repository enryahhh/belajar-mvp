package com.example.belajarmvp1.model;

import com.example.belajarmvp1.helper.StaticTodos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Todo implements ITodo, Serializable {
    private String id;
    private String todo;
    private boolean isDone;
    private Date tgl;

    private List<Todo> todos = new ArrayList<Todo>();

    public Todo(){

    }
    public Todo(String id, String todo){
        this.id = id;
        this.todo = todo;
        this.isDone = false;
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        this.tgl = today.getTime();
    }

    public String getIdTodo() {
        return id;
    }

    public String getTodo(){
        return todo;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public Date getTgl() {
        return tgl;
    }

    //    public void setTodo(String id,String todo) {
//        this.id = id;
//        this.todo = todo;
//        this.isDone = false;
//        Calendar today = Calendar.getInstance();
//        today.set(Calendar.HOUR_OF_DAY, 0);
//        this.tgl = today.getTime();
//    }



    @Override
    public List<Todo> getTodos() {
        return StaticTodos.todos;
    }

    @Override
    public void addTodo(Todo todo) {
        StaticTodos.todos.add(todo);
    }

    @Override
    public void removeTodo(String id) {

    }

    @Override
    public String toString(){
        return todo;
    }
}
