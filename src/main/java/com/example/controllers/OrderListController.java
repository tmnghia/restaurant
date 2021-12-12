package com.example.controllers;

import java.util.ArrayList;

import com.example.models.Order;
import com.example.models.OrderList;
import com.example.views.OrderListView;
import com.example.views.OrderView;

public class OrderListController {

    OrderList model;
    OrderListView view;

    public OrderListController(OrderList model, OrderListView view) {
        this.model = model;
        this.view = view;
    }

    public boolean addOrder(Order order) {
        if (order == null)
            return false;

        return model.addOrder(order);
    }

    public boolean removeOrder(Order order) {
        if (order == null)
            return false;

        return model.removeOrder(order);
    }

    public boolean updateOrder(Order oldItem, Order newItem) {
        return model.updateOrder(oldItem, newItem);
    }

    public Order getOrder() {
        Order order = null;
        String orderID = view.getOrderID();
        order = model.getOrder(orderID);
        if (order == null) {
            order = new Order(orderID);
            model.addOrder(order);
        }

        return order;
    }

    public int getOrderListAction() {
        return view.getAction();
    }

    public void showOrders() {
        System.out.println("OrderListController.showOrders()");
        ArrayList<Order> orders = model.getOrders();
        for (Order order : orders) {
            OrderController orderController = new OrderController(order, new OrderView());
            orderController.showOrder();
        }
    }
}
