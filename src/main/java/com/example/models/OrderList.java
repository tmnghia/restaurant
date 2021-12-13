package com.example.models;

import java.util.ArrayList;

import com.example.dao.OrderDAO;

public class OrderList {

    private static OrderList instance = null;
    private ArrayList<Order> orders = null;

    private OrderList() {
        orders = new ArrayList<>();
        loadOrderItems();
    }

    private void loadOrderItems() {
        if (orders.isEmpty()) {
            orders = OrderDAO.getInstance().readFromDB();
        }
    }

    public static OrderList getInstance() {
        OrderList i = instance;
        if (i == null) {
            synchronized (OrderList.class) {
                i = instance;
                if (i == null) {
                    i = new OrderList();
                    instance = i;
                }
            }
        }
        return instance;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public Order getOrder(String id) {
        for (Order order : orders) {
            if (order.getId().equals(id)) {
                return order;
            }
        }
        return null;
    }

    public boolean addOrder(Order item) {
        for (Order order : orders) {
            if (order.equals(item)) {
                return false;
            }
        }
        orders.add(item);
        return true;
    }

    public boolean removeOrder(Order item) {
        try {
            if (orders.removeIf(order -> order.equals(item))) {
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

    public boolean updateOrder(Order oldItem, Order newItem) {
        try {
            if (orders.removeIf(item -> item.equals(oldItem))) {
                orders.add(newItem);
            }
        } catch (NullPointerException e) {
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public void saveOrders() {
        System.out.println("OrderList.saveOrders()");
        OrderDAO.getInstance().writeToDB(orders);
    }
}
