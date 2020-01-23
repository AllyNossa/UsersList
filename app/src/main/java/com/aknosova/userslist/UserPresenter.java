package com.aknosova.userslist;

import android.util.Log;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class UserPresenter {
    private UserRepository userRepository;
    private MvpView mvpView;
    private Disposable disposable;

    public UserPresenter() {
        userRepository = new UserRepository();
    }

    public void attach(final MvpView mvpView) {
        this.mvpView = mvpView;

        disposable = userRepository.getUsers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                            if (mvpView != null) {
                                mvpView.showUsers(result);
                            }
                        },
                        error -> Log.e(MainActivity.class.getName(), "Ошибка ", error));
    }

    public void detach() {
        disposable.isDisposed();
        if (mvpView != null) {
            mvpView = null;
        }
    }
}
