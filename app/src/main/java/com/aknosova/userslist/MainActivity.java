package com.aknosova.userslist;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MvpView {

    RecyclerView recyclerView;
    UserPresenter userPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPresenter();
        initRecycler();
    }

    @Override
    public void showUsers(List<User> users) {
        recyclerView.setAdapter(new UsersAdapter(users));
    }

    @Override
    protected void onStart() {
        super.onStart();
        userPresenter.attach(this);
    }

    @Override
    protected void onStop() {
        userPresenter.detach();
        super.onStop();
    }

    private void initRecycler() {
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }

    private void initPresenter() {
        if (userPresenter == null) {
            userPresenter = new UserPresenter();
        }
    }
}
