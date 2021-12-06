package com.example.views;

public class MainView {
    private MainView() {
    }

    public static MainView instance = null;

    public static MainView getInstance() {
        if (instance == null) {
            synchronized (MainView.class) {
                if (instance == null) {
                    instance = new MainView();
                }
            }
        }
        return instance;
    }

    public void showMenu() {
        System.out.println("\n========== RESTAURANT MANAGEMENT ==========");
        System.out.println("1. Menu Management");
        System.out.println("2. Order");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }
}
