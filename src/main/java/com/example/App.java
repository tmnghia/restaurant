package com.example;

import com.example.controllers.MainController;
import com.example.controllers.MenuController;
import com.example.models.Menu;
import com.example.views.MainView;
import com.example.views.MenuView;

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
                                break;

                            default:
                                break;
                        }
                    } while (menuAction != 0);

                    break;
                case 2:
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
