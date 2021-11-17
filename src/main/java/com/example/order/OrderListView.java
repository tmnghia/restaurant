package com.example.order;

import java.util.ArrayList;

import com.example.common.repository.RepoView;

public class OrderListView implements RepoView<ArrayList<Order>> {

    @Override
    public void showRepo(ArrayList<Order> items) {
        for (Order order : items) {
            System.out.println(order);
        }
    }
    
}
