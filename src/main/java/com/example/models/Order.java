package com.example.models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Order implements Serializable {
    private String id;
    private double totalPrice = 0;
    private Map<Product, Integer> orderItems;

    public Order(String id) {
        setId(id);
        orderItems = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public Map<Product, Integer> getOrderItems() {
        return orderItems;
    }

    public double getTotalPrice() {
        totalPrice = 0;
        for (Map.Entry<Product, Integer> entry : orderItems.entrySet()) {
            totalPrice += (entry.getValue() * entry.getKey().getPrice());
        }
        return totalPrice;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean addItem(OrderItem orderItem) {
        Menu menu = Menu.getInstance();
        Product item = menu.getItem(orderItem.getProductName());
        
        if (item == null) {
            System.err.println("Not found item with name" + orderItem.getProductName() + "in the menu list");
            return false;
        }
        int quantity = orderItem.getQuantity();

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
        Product item = menu.getItem(name);
        if (item == null) {
            System.err.printf("Not found item with name %s in the menu list", name);
            System.out.println();
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
        str.append("Product, Unit Price, Quantity, Price");
        for (Map.Entry<Product, Integer> entry : orderItems.entrySet()) {
            Product item = entry.getKey();
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
