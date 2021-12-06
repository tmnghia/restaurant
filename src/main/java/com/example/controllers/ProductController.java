package com.example.controllers;

import com.example.models.Menu;
import com.example.models.Product;
import com.example.views.ProductView;

public class ProductController {
    private Product model;
    private ProductView view;

    public ProductController() {
    }

    public ProductController(Product model, ProductView view) {
        this.model = model;
        this.view = view;
    }

    public boolean addProduct() {
        model = view.inputProductInfo();
        if (model == null)
            return false;

        return Menu.getInstance().addItem(model);
    }

    public boolean deleteProduct() {
        System.out.println("ProductController.deleteProduct()");
        String name = view.inputProductName();
        return Menu.getInstance().removeItem(name);
    }

    public boolean updateProduct() {
        String name = view.inputProductName();
        Product oldProduct = Menu.getInstance().getItem(name);
        if (oldProduct == null)
            return false;

        Product newProduct = view.inputProductInfo();
        return Menu.getInstance().updateItem(oldProduct, newProduct);
    }
}
