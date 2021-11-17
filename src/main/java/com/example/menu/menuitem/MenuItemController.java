package com.example.menu.menuitem;

public interface MenuItemController<T> {
    public String getName();

    public void setName(String name);

    public String getDescription();

    public void setDescription(String description);

    public String getImage();

    public void setImage(String image);

    public double getPrice();

    public void setPrice(double price);

    public T getType();

    public void setType(T type);

    public void showMenuItem();
}
