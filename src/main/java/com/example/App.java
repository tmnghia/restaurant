package com.example;

import java.util.InputMismatchException;

import com.example.menu.Menu;
import com.example.menu.MenuController;
import com.example.menu.MenuView;
import com.example.menu.menuitem.MenuItem;
import com.example.menu.menuitem.drink.DrinkController;
import com.example.menu.menuitem.drink.DrinkModel;
import com.example.menu.menuitem.drink.DrinkView;
import com.example.menu.menuitem.food.FoodController;
import com.example.menu.menuitem.food.FoodModel;
import com.example.menu.menuitem.food.FoodView;
import com.example.order.Bill;
import com.example.order.BillDAO;
import com.example.order.Order;
import com.example.order.OrderController;
import com.example.order.OrderList;
import com.example.order.OrderListController;
import com.example.order.OrderListView;
import com.example.order.OrderView;
import com.example.utils.userio.UserIO;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    private static Menu menu;
    private static MenuView menuView;
    private static MenuController menuController;

    private static OrderList orderList = null;
    private static OrderListView orderListView = null;
    private static OrderListController orderlistController = null;

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        int action = -1;
        UserIO userIO = UserIO.getInstance();

        menu = Menu.getInstance();
        menuView = new MenuView();
        menuController = new MenuController(menu, menuView);

        orderList = OrderList.getInstance();
        orderListView = new OrderListView();
        orderlistController = new OrderListController(orderList, orderListView);

        // orderView = new OrderView();
        // orderModel = new Order("1");
        // orderController = new OrderController(orderModel, orderView);

        do {
            try {
                System.out.println("\n========== RESTAURANT MANAGEMENT ==========");
                System.out.println("1. Menu Management");
                System.out.println("2. Order");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");

                action = userIO.input.nextInt();
                userIO.input.nextLine();

                switch (action) {
                case 1:
                    handleMenu();
                    break;

                case 2:
                    order();
                    break;
                case 0:
                    System.out.println("BYE...");
                    break;
                default:
                    System.out.println("Invalid action " + action);
                    break;
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input");
                userIO.input.nextLine();
                action = -1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (action != 0);

        userIO.handleClose();
    }

    private static void order() {
        int action = 0;
        String orderID;
        UserIO userIO = UserIO.getInstance();
        System.out.println("\n========== ORDER ==========");
        System.out.print("Enter order ID: ");
        orderID = userIO.input.nextLine();

        Order order = orderlistController.getItem(orderID);
        if (order == null) {
            order = new Order(orderID);
            System.out.println("Created a new order with ID: " + orderID);
            orderlistController.addItem(order);
        } else {
            System.out.println("Found order ID: " + orderID);
        }

        do {
            System.out.println("1. Add order item");
            System.out.println("2. Remove order item");
            System.out.println("3. Show order");
            System.out.println("4. Billing");
            System.out.println("0. Back");
            System.out.print("Enter your choice: ");

            action = userIO.input.nextInt();
            userIO.input.nextLine();

            switch (action) {
            case 1:
                addOrderItem(order);
                break;
            case 2:
                removeOrderItem(order);
                break;
            case 3:
                showOrder(order);
            case 4:
                billing(order);
            case 0:
                break;
            default:
                System.err.println("Invalid action " + action);
                break;
            }

        } while (action != 0);
    }

    private static void billing(Order order) {
        Bill bill = new Bill(order.getId(), order);
        bill.exportToCSV();
    }

    private static void showOrder(Order order) {
        OrderController orderController = new OrderController(order, new OrderView());
        orderController.showOrder();
    }

    private static void removeOrderItem(Order order) {
        // OrderController orderController = new OrderController(order, new OrderView());
    }

    private static void addOrderItem(Order order) {
        String name = null;
        int quantity = 0;
        OrderController orderController = new OrderController(order, new OrderView());

        UserIO userIO = UserIO.getInstance();

        System.out.print("Enter name: ");
        name = userIO.input.nextLine();
        System.out.print("Enter quantity: ");
        quantity = userIO.input.nextInt();
        userIO.input.nextLine();

        orderController.addItem(name, quantity);
    }

    private static void handleMenu() {
        UserIO userIO = UserIO.getInstance();
        int action = 0;

        do {
            System.out.println("\n========== MENU MANAGEMENT ==========");
            System.out.println("1. Food");
            System.out.println("2. Drink");
            System.out.println("3. Show menu");
            System.out.println("0. Back");
            System.out.print("Enter your choice: ");
            action = userIO.input.nextInt();
            userIO.input.nextLine();

            switch (action) {
            case 1:
                handleFoodMenu();
                break;
            case 2:
                handleDrinkMenu();
                break;
            case 3:
                showMenu();
                break;
            default:
                System.out.println("Invalid action " + action);
                break;
            }
        } while (action != 0);

    }

    private static void showMenu() {
        System.out.println("\n========== MENU ==========");
        menuController.showMenu();
    }

    private static void handleDrinkMenu() {
        int action = -1;
        UserIO userIO = UserIO.getInstance();

        do {
            System.out.println("\n========== DRINK MANAGEMENT ==========");
            System.out.println("1. Add Drink");
            System.out.println("2. Delete Drink");
            System.out.println("3. Update Drink");
            System.out.println("0. Back");
            System.out.print("Enter your choice: ");
            action = userIO.input.nextInt();
            userIO.input.nextLine();

            switch (action) {
            case 1:
                addDrink();
                break;
            case 2:
                deleteItem();
                break;
            case 3:
                updateDrink();
                break;
            case 0:
                break;

            default:
                System.out.println("Invalid action " + action);
                break;
            }
        } while (action != 0);
    }

    private static void updateDrink() {
        String oldName, newName, description;
        double price;
        int type;
        MenuItem oldItem;
        DrinkController drinkController;

        UserIO userIO = UserIO.getInstance();
        System.out.print("Enter old food name: ");
        oldName = userIO.input.nextLine();

        oldItem = menuController.getItem(oldName);

        if (oldItem == null) {
            System.err.println("Not found item with name: " + oldName);
            return;
        }

        DrinkModel newItem = (DrinkModel) oldItem;
        drinkController = new DrinkController(newItem, new DrinkView());

        System.out.print("Enter new food name: ");
        newName = userIO.input.nextLine();
        drinkController.setName(newName);

        System.out.print("Enter description: ");
        description = userIO.input.nextLine();
        drinkController.setDescription(description);

        System.out.print("Enter price: ");
        price = userIO.input.nextDouble();
        drinkController.setPrice(price);

        System.out.print("Enter type (0: Soft drink | 1: Alcohol): ");
        type = userIO.input.nextInt();
        userIO.input.nextLine();
        drinkController.setType(DrinkModel.Type.values()[type]);

        menuController.updateItem(oldItem, newItem);
    }

    private static void deleteItem() {
        String name = null;
        UserIO userIO = UserIO.getInstance();

        System.out.print("Enter name: ");
        name = userIO.input.nextLine();
        menuController.removeItem(name);
    }

    private static void addDrink() {
        String name, description, image;
        double price;
        int type;

        UserIO userIO = UserIO.getInstance();
        System.out.print("Enter name: ");
        name = userIO.input.nextLine();
        System.out.print("Enter description: ");
        description = userIO.input.nextLine();
        image = "Image";
        System.out.print("Enter price: ");
        price = userIO.input.nextDouble();
        System.out.print("Enter type (0: Soft water | 1: Alcohol): ");
        type = userIO.input.nextInt();
        userIO.input.nextLine();

        DrinkModel drink = new DrinkModel(name, description, image, price, DrinkModel.Type.values()[type]);
        menuController.addItem(drink);
    }

    private static void handleFoodMenu() {
        int action = -1;
        UserIO userIO = UserIO.getInstance();

        do {
            System.out.println("\n========== FOOD MANAGEMENT ==========");
            System.out.println("1. Add Food");
            System.out.println("2. Delete Food");
            System.out.println("3. Update Food");
            System.out.println("0. Back");
            System.out.print("Enter your choice: ");
            action = userIO.input.nextInt();
            userIO.input.nextLine();

            switch (action) {
            case 1:
                addFood();
                break;
            case 2:
                deleteItem();
                break;
            case 3:
                updateFood();
                break;
            case 0:
                break;

            default:
                System.out.println("Invalid action " + action);
                break;
            }
        } while (action != 0);
    }

    private static void updateFood() {
        String oldName, newName, description;
        double price;
        int type;
        MenuItem oldItem;
        FoodController foodController;

        UserIO userIO = UserIO.getInstance();
        System.out.print("Enter old food name: ");
        oldName = userIO.input.nextLine();

        oldItem = menuController.getItem(oldName);

        if (oldItem == null) {
            System.err.println("Not found item with name: " + oldName);
            return;
        }

        FoodModel newItem = (FoodModel) oldItem;
        foodController = new FoodController(newItem, new FoodView());

        System.out.print("Enter new food name: ");
        newName = userIO.input.nextLine();
        foodController.setName(newName);

        System.out.print("Enter description: ");
        description = userIO.input.nextLine();
        foodController.setDescription(description);

        System.out.print("Enter price: ");
        price = userIO.input.nextDouble();
        foodController.setPrice(price);

        System.out.print("Enter type (0: Breakfast | 1: Lunch | 2: Dinner): ");
        type = userIO.input.nextInt();
        userIO.input.nextLine();
        foodController.setType(FoodModel.Type.values()[type]);

        menuController.updateItem(oldItem, newItem);
    }

    private static void addFood() {
        String name, description, image;
        double price;
        int type;

        UserIO userIO = UserIO.getInstance();
        System.out.print("Enter name: ");
        name = userIO.input.nextLine();
        System.out.print("Enter description: ");
        description = userIO.input.nextLine();
        image = "Image";
        System.out.print("Enter price: ");
        price = userIO.input.nextDouble();
        System.out.print("Enter type (0: Breakfast | 1: Lunch | 2: Dinner): ");
        type = userIO.input.nextInt();
        userIO.input.nextLine();

        FoodModel food = new FoodModel(name, description, image, price, FoodModel.Type.values()[type]);
        menuController.addItem(food);
    }
}
