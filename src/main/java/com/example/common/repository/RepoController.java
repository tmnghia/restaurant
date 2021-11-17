package com.example.common.repository;

public interface RepoController<S, T> {
    boolean addItem(T item);
    boolean removeItem(T item);
    boolean updateItem(T oldItem, T newItem);
    T getItem(String id);
    S getItems();
    void showAllItems();
}
