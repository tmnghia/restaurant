package com.example.order;

import java.util.ArrayList;

import com.example.common.repository.RepoController;

public class OrderListController implements RepoController<ArrayList<Order>, Order> {

    OrderList model;
    OrderListView view;

    public OrderListController(OrderList model, OrderListView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public boolean addItem(Order item) {
        return model.addItem(item);
    }

    @Override
    public boolean removeItem(Order item) {
        return model.removeItem(item);
    }

    @Override
    public boolean updateItem(Order oldItem, Order newItem) {
        return model.updateItem(oldItem, newItem);
    }

    @Override
    public Order getItem(String id) {
        return model.getItem(id);
    }

    @Override
    public ArrayList<Order> getItems() {
        return model.getItems();
    }

    @Override
    public void showAllItems() {
        view.showRepo(model.getItems());
    }
}
