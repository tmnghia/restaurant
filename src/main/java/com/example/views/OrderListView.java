package com.example.views;

import java.util.ArrayList;

import com.example.common.repository.RepoView;
import com.example.models.Order;

public class OrderListView implements RepoView<ArrayList<Order>> {

    @Override
    public void showRepo(ArrayList<Order> items) {
        for (Order order : items) {
            System.out.println(order);
        }
    }
    
}
