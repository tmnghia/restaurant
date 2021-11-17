package com.example.common.repository;

import java.util.ArrayList;

public interface Repo<T> {
    public ArrayList<T> getItems();

    public T getItem(String id);

    public boolean addItem(T item);

    public boolean removeItem(T item);

    public boolean updateItem(T oldItem, T newItem);
}
