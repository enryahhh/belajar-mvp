package com.example.belajarmvp1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.belajarmvp1.R;
import com.example.belajarmvp1.model.ITodo;
import com.example.belajarmvp1.model.Todo;
import com.example.belajarmvp1.presenter.TodoPresenter;
import com.example.belajarmvp1.view.ITodoView;

public class CreateTodoActivity extends AppCompatActivity implements ITodoView {
    TodoPresenter presenter;
    Todo todo_;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_todo);
        Button btnSave = findViewById(R.id.btnSaveTodo);
        EditText todo = findViewById(R.id.todo);
//        CheckBox isDone = findViewById(R.id.isDone);
        todo_ =(Todo) getIntent().getSerializableExtra("TODO");
        presenter = new TodoPresenter(this,todo_);
//        presenter = (TodoPresenter) getIntent().getSerializableExtra("presenter");
        btnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                presenter.onSaveTodo(String.valueOf(todo.getText()));
            }
        });
    }


    @Override
    public void showMessage() {
        System.out.println("berhasil");
    }

    @Override
    public void showTodos() {

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Intent i = new Intent();
        i.putExtra("DATA",todo_);
        setResult(RESULT_OK,i);
        finish();
    }
}