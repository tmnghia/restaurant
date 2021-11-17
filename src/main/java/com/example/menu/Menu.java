package com.example.menu;

import java.util.ArrayList;

import com.example.menu.menuitem.MenuItem;

public class Menu {
    private ArrayList<MenuItem> menuItems;
    private MenuDAO dao;

    private static Menu instance;

    private Menu() {
        menuItems = new ArrayList<>();
        dao = MenuDAO.getInstance();
        menuItems = dao.readFromDB();
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

    public ArrayList<MenuItem> getItems() {
        return menuItems;
    }

    public MenuItem getItem(String name) {
        for (MenuItem menuItem : menuItems) {
            if (menuItem.getName().equalsIgnoreCase(name)) {
                return menuItem;
            }
        }
        return null;
    }

    public boolean addItem(MenuItem item) {
        for (MenuItem menuItem : menuItems) {
            if (menuItem.equals(item)) {
                System.err.println("item already exist");
                return false;
            }
        }
        menuItems.add(item);
        dao.writeToDB(menuItems);

        return true;
    }

    public boolean removeItem(String name) {
        for (MenuItem item : menuItems) {
            if (item.getName().equals(name)) {
                menuItems.remove(item);
                dao.writeToDB(menuItems);

                return true;
            }
        }
        return false;
    }

    public boolean updateItem(MenuItem oldItem, MenuItem newItem) {
        for (MenuItem menuItem : menuItems) {
            if (menuItem.equals(oldItem)) {
                menuItems.remove(oldItem);
                menuItems.add(newItem);
                dao.writeToDB(menuItems);

                return true;
            }
        }
        return false;
    }
}
