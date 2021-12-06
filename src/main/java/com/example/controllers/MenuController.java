package com.example.controllers;

import com.example.models.Menu;
import com.example.models.Product;
import com.example.views.MenuView;
import com.example.views.ProductView;

public class MenuController {
    private Menu model;
    private MenuView view;

    public MenuController(Menu model, MenuView view) {
        this.model = model;
        this.view = view;
    }

    public void addItem(Product item) {
        model.addItem(item);
    }

    public void removeItem(String name) {
        model.removeItem(name);
    }

    public void updateItem(Product oldItem, Product newItem) {
        model.updateItem(oldItem, newItem);
    }

    public Product getItem(String name) {
        return model.getItem(name);
    }

    public void showMenu() {
        view.showMenu(model);
    }

    public int getMenuAction() {
        return view.getMenuAction();
    }

    public void addMenuItem() {
        Product product = null;
        ProductView productView = new ProductView();
        ProductController productController = new ProductController(product, productView);
        productController.addProduct();
    }

    public void deleteMenuItem() {
        ProductView productView = new ProductView();
        ProductController productController = new ProductController(null, productView);
        productController.deleteProduct();
    }

    public void updateMenuItem() {
        ProductView productView = new ProductView();
        ProductController productController = new ProductController(null, productView);
        productController.updateProduct();
    }

    public void saveMenu() {
        model.saveMenu();
    }
}
