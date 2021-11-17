package com.example.menu;

import com.example.menu.menuitem.MenuItem;

public class MenuView {
    public void showMenu(Menu model) {
        for (MenuItem item : model.getItems()) {
            System.out.println(item);
            System.out.println();
        }
    }
}
