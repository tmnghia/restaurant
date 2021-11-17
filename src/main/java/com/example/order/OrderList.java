package com.example.order;

import java.util.ArrayList;

import com.example.common.repository.Repo;

public class OrderList implements Repo<Order> {

    private static OrderList instance = null;
    private ArrayList<Order> orderList = null;

    private OrderList() {
        orderList = new ArrayList<>();
    }

    public static OrderList getInstance() {
        if (instance == null) {
            synchronized (OrderList.class) {
                if (instance == null) {
                    instance = new OrderList();
                }
            }
        }
        return instance;
    }

    @Override
    public ArrayList<Order> getItems() {
        return orderList;
    }

    @Override
    public Order getItem(String id) {
        for (Order order : orderList) {
            if (order.getId().equals(id)) {
                return order;
            }
        }
        return null;
    }

    @Override
    public boolean addItem(Order item) {
        for (Order order : orderList) {
            if (order.equals(item)) {
                return false;
            }
        }
        orderList.add(item);
        return true;
    }

    @Override
    public boolean removeItem(Order item) {
        try {
            if (orderList.removeIf(order -> item.equals(item))) {
                System.out.println("Removed item: " + item);
            }
        } catch (NullPointerException e) {
            System.err.println("Not found item to remove");
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateItem(Order oldItem, Order newItem) {
        try {
            if (orderList.removeIf(item -> item.equals(oldItem))) {
                orderList.add(newItem);
            }
        } catch (NullPointerException e) {
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
