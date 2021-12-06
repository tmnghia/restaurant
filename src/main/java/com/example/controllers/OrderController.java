package com.example.controllers;

import com.example.models.Order;
import com.example.views.OrderView;

public class OrderController {
    Order model;
    OrderView view;

    public OrderController(Order model, OrderView view) {
        this.model = model;
        this.view = view;
    }

    public void addItem(String name, int quantity) {
        model.addItem(name, quantity);
    }

    public void removeItem(String name, int quantity) {
        model.removeItem(name, quantity);
    }

    public void showOrder() {
        view.showOrder(model);
    }
}
