package com.example.menu;

import com.example.menu.menuitem.MenuItem;

public class MenuController {
    private Menu model;
    private MenuView view;

    public MenuController(Menu model, MenuView view) {
        this.model = model;
        this.view = view;
    }

    public void addItem(MenuItem item) {
        model.addItem(item);
    }

    public void removeItem(String name) {
        model.removeItem(name);
    }

    public void updateItem(MenuItem oldItem, MenuItem newItem) {
        model.updateItem(oldItem, newItem);
    }

    public MenuItem getItem(String name) {
        return model.getItem(name);
    }

    public void showMenu() {
        view.showMenu(model);
    }
}
