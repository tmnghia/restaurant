package com.example.utils.userio;

import java.util.Scanner;

public class UserIO {
    private static UserIO instance = null;
    public Scanner input = null;

    private UserIO() {
        input = new Scanner(System.in);
    }

    public static UserIO getInstance() {
        if (instance == null) {
            synchronized (UserIO.class) {
                if (instance == null) {
                    instance = new UserIO();
                }
            }
        }

        return instance;
    }

    public void handleClose() {
        if (input != null) {
            input.close();
        }
    }
}
