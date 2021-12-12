package com.example.views;

import java.util.Map;

import com.example.models.Order;
import com.example.models.Product;
import com.example.utils.userio.UserIO;

public class OrderView {
    public void showOrder(Order order) {
        if (order == null)
        {
            System.out.println("No order item");
            return;
        }

        System.out.println("\n================== ORDER DETAILS ==================");
        System.out.println("Order ID: " + order.getId());
        System.out.println("        Name        | Unit Price | Quantity | Total Price");
        for (Map.Entry<Product, Integer> entry : order.getOrderItems().entrySet()) {
            Product item = entry.getKey();
            System.out.printf("%19s |%12.2f|%10d|%12.2f", item.getName(), item.getPrice(), entry.getValue(),
                    item.getPrice() * entry.getValue());
            System.out.println();
        }
        System.out.printf("%19s %37.2f", "Total", order.getTotalPrice());
        System.out.println();
    }

    public String getOrderItemName() {
        System.out.print("Enter product name: ");
        return UserIO.getInstance().getStringFromUser();
    }

    public int getOrderItemQuantity() {
        System.out.print("Enter quantity: ");
        return UserIO.getInstance().getIntegerFromUser();
    }

    public int getOrderAction() {
        int action = -1;
        do {
            System.out.println();
            System.out.println("1. Add order item.");
            System.out.println("2. Remove Order item.");
            System.out.println("3. Show order");
            System.out.println("4. Billing");
            System.out.println("0. Save and back.");
            System.out.print("Enter your choice: ");

            action = UserIO.getInstance().getIntegerFromUser();

        } while (action != 0 && action != 1 && action != 2 && action != 3 && action != 4);

        return action;
    }
}
