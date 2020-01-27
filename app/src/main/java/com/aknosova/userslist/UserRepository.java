package com.aknosova.userslist;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class UserRepository {
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

    public Observable<List<User>> getUsers() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Observable.just(getTempUsers()).subscribeOn(Schedulers.io());
    }
}
