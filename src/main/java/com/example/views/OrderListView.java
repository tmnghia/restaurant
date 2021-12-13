package com.example.views;

import java.util.ArrayList;
import java.util.Map;

import com.example.models.Order;
import com.example.models.Product;
import com.example.utils.userio.UserIO;

public class OrderListView {

    public void showOrderList(ArrayList<Order> items) {
        for (Order order : items) {
            System.out.println(order);
        }
    }

    public String getOrderID() {
        System.out.print("Enter order ID: ");
        return UserIO.getInstance().getStringFromUser();
    }

    public void showOrder(Order order) {
        if (order == null)
            return;

        System.out.println("Order ID: " + order.getId());
        Map<Product, Integer> items = order.getOrderItems();

        System.out.printf("%-15s | %-10s | %-10s | %-10s", "Name", "Unit Price", "Quantity", "Total Price");
        for (Map.Entry<Product, Integer> item : items.entrySet()) {
            Product product = item.getKey();
            Integer quantity = item.getValue();
            System.out.printf("%-15s | %-10f | %-10d | %-10f",
                    product.getName(), product.getPrice(), quantity, quantity * product.getPrice());
        }
    }

    public int getAction() {
        int action = -1;

        do {
            System.out.println();
            System.out.println("1. Add or Update order.");
            System.out.println("2. Delete order");
            System.out.println("3. Show all orders");
            System.out.println("0. Save and back");
            System.out.print("Enter your choice: ");

            action = UserIO.getInstance().getIntegerFromUser();

        } while (action != 0 && action != 1 && action != 2 && action != 3);

        return action;
    }
}
