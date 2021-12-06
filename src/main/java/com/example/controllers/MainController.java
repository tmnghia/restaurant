package com.example.controllers;

import com.example.utils.userio.UserIO;
import com.example.views.MainView;

public class MainController {
    private MainView mainView;

    public MainController(MainView mainView) {
        this.mainView = mainView;
    }

    public int getUserAction() {
        return UserIO.getInstance().getIntegerFromUser();
    }

    public void showMenu() {
        mainView.showMenu();
    }

}
