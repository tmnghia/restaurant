package com.example.menu.menuitem.food;

import com.example.menu.menuitem.MenuItemView;

public class FoodView implements MenuItemView<FoodModel> {

    @Override
    public void showMenuItem(FoodModel item) {
        System.out.println(item);
    }
}
