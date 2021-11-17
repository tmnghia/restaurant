package com.example.order;

import java.util.HashMap;
import java.util.Map;

import com.example.menu.Menu;
import com.example.menu.menuitem.MenuItem;

public class Order {
    private String id;
    private double totalPrice = 0;
    private Map<MenuItem, Integer> orderItems;

    public Order(String id) {
        setId(id);
        orderItems = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public Map<MenuItem, Integer> getOrders() {
        return orderItems;
    }

    public double getTotalPrice() {
        totalPrice = 0;
        for (Map.Entry<MenuItem, Integer> entry : orderItems.entrySet()) {
            totalPrice += (entry.getValue() * entry.getKey().getPrice());
        }
        return totalPrice;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean addItem(String name, int quantity) {
        Menu menu = Menu.getInstance();
        MenuItem item = menu.getItem(name);
        if (item == null) {
            System.err.printf("Not found item with name %s in the menu list\n", name);
            return false;
        }

        if (orderItems.get(item) == null) {
            orderItems.put(item, quantity);
        } else {
            quantity += orderItems.get(item);
            orderItems.put(item, quantity);
        }

        return true;
    }

    public boolean removeItem(String name, int quantity) {
        Menu menu = Menu.getInstance();
        MenuItem item = menu.getItem(name);
        if (item == null) {
            System.err.printf("Not found item with name %s in the menu list\n", name);
            return false;
        }

        Integer currentQuantity = orderItems.get(item);
        if (currentQuantity == null) {
            return false;
        } else {
            currentQuantity = currentQuantity > quantity ? currentQuantity - quantity : 0;
            if (currentQuantity == 0) {
                orderItems.remove(item);
            } else {
                orderItems.put(item, currentQuantity);
            }
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Order ID: " + id + "\n");
        str.append("Product, Unit Price, Quantity, Price");
        for (Map.Entry<MenuItem, Integer> entry : orderItems.entrySet()) {
            MenuItem item = entry.getKey();
            int quantity = (int)entry.getValue();
            str.append("\n");
            str.append(item.getName());
            str.append(",");
            str.append(item.getPrice());
            str.append(",");
            str.append(quantity);
            str.append(",");
            str.append(quantity * item.getPrice());
        }
        str.append("\n,,,");
        str.append(totalPrice);
        str.append("\n");
        return str.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Order other = (Order) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
