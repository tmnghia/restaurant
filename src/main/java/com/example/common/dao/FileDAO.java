package com.example.common.dao;

public interface FileDAO<T> {
    void writeToDB(T objects);
    T readFromDB();
}
