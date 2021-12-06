package com.example.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.example.common.dao.FileDAO;
import com.example.models.Product;

public class MenuDAO implements FileDAO<ArrayList<Product>> {
    private final String MENU_DB = "menu.dat";
    private static MenuDAO instance;

    private MenuDAO() {
    }

    public static MenuDAO getInstance() {
        if (instance == null) {
            synchronized (MenuDAO.class) {
                if (instance == null) {
                    instance = new MenuDAO();
                }
            }
        }
        return instance;
    }

    @Override
    public void writeToDB(ArrayList<Product> objects) {
        FileOutputStream fos = null;
        ObjectOutput oos = null;

        try {
            fos = new FileOutputStream(MENU_DB);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(objects);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public ArrayList<Product> readFromDB() {
        ArrayList<Product> menuItems = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInput ois = null;

        try {
            fis = new FileInputStream(MENU_DB);
            ois = new ObjectInputStream(fis);
            menuItems = (ArrayList<Product>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Nothing to read");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return menuItems;
    }
}
