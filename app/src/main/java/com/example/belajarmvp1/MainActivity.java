package com.example.belajarmvp1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.belajarmvp1.activity.CreateTodoActivity;
import com.example.belajarmvp1.contract.TodoContract;
import com.example.belajarmvp1.fragment.CreateTodoDialogFragment;
import com.example.belajarmvp1.model.Todo;
import com.example.belajarmvp1.presenter.TodoPresenter;
import com.example.belajarmvp1.presenter.TodoPresenter2;
import com.example.belajarmvp1.view.ITodoView;
import com.google.android.material.snackbar.Snackbar;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.belajarmvp1.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity implements TodoContract.View {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    TodoPresenter2 presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new TodoPresenter2(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//                Intent intent = new Intent(MainActivity.this, CreateTodoActivity.class);
//                intent.putExtra("TODO",new Todo());
//                startActivity(intent);
//                someActivityResultLauncher.launch(intent);
                CreateTodoDialogFragment.newInstance(30,presenter).show(getSupportFragmentManager(), "dialog");
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void showMessage() {

    }

    @Override
    public void showTodos(List<Todo> items) {

    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        presenter.onStart();
//        Log.i("","ini onstart");
//    }
//
//    @Override
//    public void showMessage() {
//        System.out.println("show message main activity");
//    }
//
//    @Override
//    public void showTodos() {
//
//    }
//
//    @Override
//    public void onActivityReenter(int resultCode, Intent data) {
//        super.onActivityReenter(resultCode, data);
//    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//            if (resultCode == RESULT_OK) {
//                Log.i("berhasil",data.getSerializableExtra("DATA").toString());
//            }
//
//    }

//    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
//            new ActivityResultContracts.StartActivityForResult(),
//            new ActivityResultCallback<ActivityResult>() {
//                @Override
//                public void onActivityResult(ActivityResult result) {
//                    if (result.getResultCode() == Activity.RESULT_OK) {
//                        // There are no request codes
//                        Intent data = result.getData();
////                        Log.i("berhasil",);
//                        System.out.println(data.getSerializableExtra("DATA").toString());
//                    }
//                }
//            });
}