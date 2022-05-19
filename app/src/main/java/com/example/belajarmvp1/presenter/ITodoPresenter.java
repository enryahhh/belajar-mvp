package com.example.belajarmvp1.presenter;

public interface ITodoPresenter {
    void onSaveTodo(String todo);
    void onStart();
    void onDeleteTodo();
    void onDestroy();
}
