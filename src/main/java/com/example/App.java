package com.example;

import com.example.controllers.MainController;
import com.example.controllers.MenuController;
import com.example.controllers.OrderController;
import com.example.controllers.OrderListController;
import com.example.models.Menu;
import com.example.models.Order;
import com.example.models.OrderList;
import com.example.views.MainView;
import com.example.views.MenuView;
import com.example.views.OrderListView;
import com.example.views.OrderView;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        int action = -1;
        MainView mainView = MainView.getInstance();
        MainController mainController = new MainController(mainView);

        do {
            mainController.showMenu();
            action = mainController.getUserAction();
            System.out.println("action: " + action);

            switch (action) {
                // Menu Management
                case 1:
                    int menuAction = -1;
                    Menu menu = Menu.getInstance();
                    MenuView menuView = new MenuView();
                    MenuController menuController = new MenuController(menu, menuView);

                    do {
                        menuAction = menuController.getMenuAction();
                        switch (menuAction) {
                            case 1:
                                menuController.showMenu();
                                break;
                            case 2:
                                menuController.addMenuItem();
                                break;
                            case 3:
                                menuController.deleteMenuItem();
                                break;
                            case 4:
                                menuController.updateMenuItem();
                                break;
                            case 0:
                                menuController.saveMenu();
                                break;

                            default:
                                break;
                        }
                    } while (menuAction != 0);

                    break;

                // Ordering
                case 2:
                    int orderAction = -1;
                    int orderListAction = -1;

                    OrderList orderList = OrderList.getInstance();
                    OrderListView orderListView = new OrderListView();
                    OrderListController orderListController = new OrderListController(orderList, orderListView);

                    do {
                        orderListAction = orderListController.getOrderListAction();
                        Order order = null;

                        switch (orderListAction) {
                            // Add or update the order
                            case 1:
                                order = orderListController.getOrder();
                                orderListController.addOrder(order);
                                OrderController orderController = new OrderController(order, new OrderView());
                                do {
                                    orderAction = orderController.getOrderAction();
                                    switch (orderAction) {
                                        case 1:
                                            orderController.addOrderItem();
                                            break;
                                        case 2:
                                            orderController.removeOrderItem();
                                            break;
                                        case 3:
                                            orderController.showOrder();
                                            break;
                                        case 4:
                                            orderController.billing();
                                            break;
                                        case 0:
                                            break;

                                        default:
                                            break;
                                    }
                                } while (orderAction != 0);
                                break;
                            // Delete the order
                            case 2:
                                order = orderListController.getOrder();
                                orderListController.removeOrder(order);
                                break;
                            // Show all orders
                            case 3:
                                orderListController.showOrders();
                                break;
                            // Save order list then exit
                            case 0:
                                orderListController.saveOrders();
                                break;
                            default:
                                break;
                        }
                    } while (orderListAction != 0);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    break;
            }

        } while (action != 0);
    }
}
