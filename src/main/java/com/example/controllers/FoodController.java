package com.example.controllers;

import com.example.models.Food;
import com.example.views.FoodView;

public class FoodController extends ProductController {
    private Food model;
    private FoodView view;

    public FoodController(Food model, FoodView view) {
        this.model = model;
        this.view = view;
    }
}
