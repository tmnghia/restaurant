package com.example.views;

import com.example.models.Menu;
import com.example.models.Product;
import com.example.utils.userio.UserIO;

public class MenuView {
    public void showMenu(Menu model) {
        System.out.println("MENU:");
        System.out.printf("%-15s | %-15s | %-15s\n", "Name", "Description", "Price");
        System.out.println("-----------------------------------------");
        for (Product item : model.getItems()) {
            System.out.printf("%-15s | %-15s | %-15s\n", item.getName(), item.getDescription(), item.getPrice());
        }
    }

    public int getMenuAction() {
        int menuAction = -1;
        boolean isValid = false;

        while (!isValid) {
            System.out.println("\n========== MENU MANAGEMENT ==========");
            System.out.println("1. Show menu items");
            System.out.println("2. Add menu item");
            System.out.println("3. Delete menu item");
            System.out.println("4. Update menu item");
            System.out.println("0. Save and Back");
            System.out.print("Enter your choice: ");
            menuAction = UserIO.getInstance().getIntegerFromUser();

            if (menuAction != 1 &&
                    menuAction != 2 &&
                    menuAction != 3 &&
                    menuAction != 4 &&
                    menuAction != 5 &&
                    menuAction != 0) {
                System.err.println("Invalid menu action");
                continue;
            }

            isValid = true;
        }

        return menuAction;
    }

    public String inputMenuItemName() {
        System.out.print("Enter item name: ");
        return UserIO.getInstance().getStringFromUser();
    }
}
