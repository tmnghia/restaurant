package com.example.controllers;

import com.example.models.Drink;
import com.example.views.DrinkView;

public class DrinkController extends ProductController {
    private Drink model;
    private DrinkView view;

    public DrinkController(Drink model, DrinkView view) {
        this.model = model;
        this.view = view;
    }
}
