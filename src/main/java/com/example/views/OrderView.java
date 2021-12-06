package com.example.views;

import java.util.Map;

import com.example.models.Order;
import com.example.models.Product;

public class OrderView {
    public void showOrder(Order order) {
        System.out.println("\n================== ORDER DETAILS ==================");
        System.out.println("        Name        | Unit Price | Quantity | Total Price");
        for (Map.Entry<Product, Integer> entry : order.getOrders().entrySet()) {
            Product item = entry.getKey();
            System.out.printf("%19s |%12.2f|%10d|%12.2f\n", item.getName(), item.getPrice(), entry.getValue(),
                    item.getPrice() * entry.getValue());
        }
        System.out.printf("%19s %37.2f\n", "Total", order.getTotalPrice());
    }
}
