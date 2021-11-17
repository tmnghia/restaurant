package com.example.menu.menuitem.drink;

import com.example.menu.menuitem.MenuItemView;

public class DrinkView implements MenuItemView<DrinkModel> {

    @Override
    public void showMenuItem(DrinkModel item) {
        System.out.println(item);
    }
    
}
