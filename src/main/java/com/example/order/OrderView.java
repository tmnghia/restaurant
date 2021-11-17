package com.example.order;

import java.util.Map;

import com.example.menu.menuitem.MenuItem;

public class OrderView {
    public void showOrder(Order order) {
        System.out.println("\n================== ORDER DETAILS ==================");
        System.out.println("        Name        | Unit Price | Quantity | Total Price");
        for (Map.Entry<MenuItem, Integer> entry : order.getOrders().entrySet()) {
            MenuItem item = entry.getKey();
            System.out.printf("%19s |%12.2f|%10d|%12.2f\n", item.getName(), item.getPrice(), entry.getValue(),
                    item.getPrice() * entry.getValue());
        }
        System.out.printf("%19s %37.2f\n", "Total", order.getTotalPrice());
    }
}
