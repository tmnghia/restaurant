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

    public int getIntegerFromUser() {
        int value = -1;
        boolean isValid = false;

        while (!isValid) {
            if (input.hasNextInt()) {
                value = input.nextInt();
                isValid = true;
            } else {
                System.err.println("Invalid integer");
                System.out.print("Input again: ");
            }
            input.nextLine();
        }

        return value;
    }

    public double getDoubleFromUser() {
        double value = 0.0;
        boolean isValid = false;

        while(!isValid) {
            if (input.hasNextDouble()) {
                value = input.nextDouble();
                isValid = true;
            } else {
                System.err.println("Invalid integer");
                System.out.print("Input again: ");
            }
            input.nextLine();
        }

        return value;
    }

    public String getStringFromUser() {
        String value = null;
        boolean isValid = false;

        while (!isValid) {
            if (input.hasNextLine()) {
                value = input.nextLine();
                isValid = true;
            }
        }

        return value;
    }

    public void handleClose() {
        if (input != null) {
            input.close();
        }
    }
}
