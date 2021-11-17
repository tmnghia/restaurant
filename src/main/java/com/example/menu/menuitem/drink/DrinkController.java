package com.example.menu.menuitem.drink;

import com.example.menu.menuitem.MenuItemController;
import com.example.menu.menuitem.drink.DrinkModel.Type;

public class DrinkController implements MenuItemController<DrinkModel.Type> {
    private DrinkModel model;
    private DrinkView view;

    public DrinkController(DrinkModel model, DrinkView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public String getName() {
        return model.getName();
    }

    @Override
    public void setName(String name) {
        model.setName(name);
    }

    @Override
    public String getDescription() {
        return model.getDescription();
    }

    @Override
    public void setDescription(String description) {
        model.setDescription(description);
    }

    @Override
    public String getImage() {
        return model.getImage();
    }

    @Override
    public void setImage(String image) {
        model.setImage(image);
    }

    @Override
    public double getPrice() {
        return model.getPrice();
    }

    @Override
    public void setPrice(double price) {
        model.setPrice(price);
    }

    @Override
    public Type getType() {
        return model.getType();
    }

    @Override
    public void setType(Type type) {
        model.setType(type);
    }

    @Override
    public void showMenuItem() {
        view.showMenuItem(model);
    }
}