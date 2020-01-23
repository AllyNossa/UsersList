package com.aknosova.userslist;

import java.util.List;

public interface MvpView {
    void showUsers(List<User> users);
}
