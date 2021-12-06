package com.example.models;

import java.util.ArrayList;

import com.example.dao.MenuDAO;

public class Menu {
    private ArrayList<Product> menuItems;

    private static Menu instance;

    private Menu() {
        menuItems = new ArrayList<>();
        loadMenuItems();
    }

    private void loadMenuItems() {
        if (menuItems.isEmpty()) {
            menuItems = MenuDAO.getInstance().readFromDB();
        }
    }

    public static Menu getInstance() {
        if (instance == null) {
            synchronized (Menu.class) {
                if (instance == null) {
                    instance = new Menu();
                }
            }
        }
        return instance;
    }

    public ArrayList<Product> getItems() {
        return menuItems;
    }

    public Product getItem(String name) {
        for (Product menuItem : menuItems) {
            if (menuItem.getName().equalsIgnoreCase(name)) {
                return menuItem;
            }
        }
        return null;
    }

    public boolean addItem(Product item) {
        if (item == null)
            return false;

        for (Product menuItem : menuItems) {
            if (menuItem.equals(item)) {
                System.err.println("item already exist");
                return false;
            }
        }
        menuItems.add(item);
        // MenuDAO.getInstance().writeToDB(menuItems);

        return true;
    }

    public boolean removeItem(String name) {
        for (Product item : menuItems) {
            if (item.getName().equals(name)) {
                menuItems.remove(item);
                // MenuDAO.getInstance().writeToDB(menuItems);

                return true;
            }
        }
        return false;
    }

    public boolean updateItem(Product oldItem, Product newItem) {
        for (int i = 0; i < menuItems.size(); i++) {
            if (menuItems.get(i).equals(oldItem)) {
                menuItems.set(i, newItem);
                return true;
            }
        }
        return false;
    }

    public boolean saveMenu() {
        MenuDAO.getInstance().writeToDB(menuItems);
        return true;
    }
}
