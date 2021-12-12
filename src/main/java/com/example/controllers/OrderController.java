package com.example.controllers;

import com.example.models.Bill;
import com.example.models.Order;
import com.example.models.OrderItem;
import com.example.views.BillView;
import com.example.views.OrderView;

public class OrderController {
    Order model;
    OrderView view;

    public OrderController(Order model, OrderView view) {
        this.model = model;
        this.view = view;
    }

    public int getOrderAction() {
        return view.getOrderAction();
    }

    public void addOrderItem() {
        String productName = view.getOrderItemName();
        int quantity = view.getOrderItemQuantity();
        OrderItem item = new OrderItem(productName, quantity);
        model.addItem(item);
    }

    public void removeOrderItem() {
        String productName = view.getOrderItemName();
        int quantity = view.getOrderItemQuantity();
        model.removeItem(productName, quantity);
    }

    public void showOrder() {
        view.showOrder(model);
    }

    public void billing() {
        Bill bill = new Bill(model.getId(), model);
        BillController billController = new BillController(bill, new BillView());
        billController.exportToCSV();
    }
}
