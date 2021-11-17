package com.example.menu.menuitem;

import java.io.Serializable;

public abstract class MenuItem implements Serializable {
    private String name;
    private String description;
    private String image;
    private double price;

    public MenuItem(String name, String description, String image, double price) {
        this.setName(name);
        this.setDescription(description);
        this.setImage(image);
        this.setPrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        final int prime = 17;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MenuItem other = (MenuItem) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equalsIgnoreCase(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return
        "Name: " + name + "\n" +
        "Description: " + description + "\n"  +
        "Image: " + image + "\n" +
        "Price: " + price;
    }
}
