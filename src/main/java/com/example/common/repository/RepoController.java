package com.example.common.repository;

public interface RepoController<S, T> {
    boolean addItem();
    boolean removeItem();
    boolean updateItem();
    T getItem();
    S getAllItems();
    void showAllItems();
}
