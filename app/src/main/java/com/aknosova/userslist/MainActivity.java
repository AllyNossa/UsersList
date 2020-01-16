package com.aknosova.userslist;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(new UsersAdapter(getTempUsers()));
    }

    private List<User> getTempUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Test1", "", ""));
        users.add(new User(2, "Test2", "", ""));
        users.add(new User(3, "Test3", "", ""));
        users.add(new User(4, "Test4", "", ""));
        users.add(new User(5, "Test5", "", ""));
        users.add(new User(6, "Test6", "", ""));
        return users;
    }
}
