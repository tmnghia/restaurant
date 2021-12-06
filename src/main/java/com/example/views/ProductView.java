package com.example.views;

import com.example.models.Drink;
import com.example.models.Food;
import com.example.models.Product;
import com.example.utils.userio.UserIO;

public class ProductView {
    public Product inputProductInfo() {
        Product product = null;
        UserIO userIO = UserIO.getInstance();

        System.out.print("Enter item name: ");
        String name = userIO.getStringFromUser();
        System.out.print("Enter item description: ");
        String description = userIO.getStringFromUser();
        System.out.print("Enter item price: ");
        double price = userIO.getDoubleFromUser();
        System.out.print("Enter item type (1: Food, 2: Drink): ");
        int itemType = userIO.getIntegerFromUser();

        switch (itemType) {
            case 1:
                System.out.println("Food types: ");
                for (Food.Type ft : Food.Type.values()) {
                    System.out.printf("%d: %s\n", ft.ordinal(), ft.name());
                }
                System.out.printf("Input your choice: ");

                int foodType = userIO.getIntegerFromUser();
                product = new Food(name, description, price, Food.Type.values()[foodType]);
                break;
            case 2:
                System.out.println("Drink types: ");
                for (Drink.Type dt : Drink.Type.values()) {
                    System.out.printf("%d: %s\n", dt.ordinal(), dt.name());
                }
                System.out.printf("Input your choice: ");

                int drinkType = userIO.getIntegerFromUser();
                product = new Drink(name, description, price, Drink.Type.values()[drinkType]);
                break;

            default:
                System.err.println("Invalid item type");
                break;
        }

        return product;
    }

    public String inputProductName() {
        System.out.print("Enter product name: ");
        return UserIO.getInstance().getStringFromUser();
    }
}
