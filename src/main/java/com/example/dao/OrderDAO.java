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
import com.example.models.Order;

public class OrderDAO implements FileDAO<ArrayList<Order>> {

    private static final String ORDER_DB = "order.dat";
    private static OrderDAO instance;

    public static OrderDAO getInstance() {
        OrderDAO i = instance;
        if (i == null) {
            synchronized (OrderDAO.class) {
                i = instance;
                if (i == null) {
                    i = new OrderDAO();
                    instance = i;
                }
            }
        }
        return instance;
    }

    @Override
    public void writeToDB(ArrayList<Order> objects) {
        System.out.println("OrderDAO.writeToDB()");
        FileOutputStream fos = null;
        ObjectOutput oos = null;

        try {
            fos = new FileOutputStream(ORDER_DB);
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

            if (fos != null) {
                try {
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public ArrayList<Order> readFromDB() {
        ArrayList<Order> orderItems = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInput ois = null;

        try {
            fis = new FileInputStream(ORDER_DB);
            ois = new ObjectInputStream(fis);
            orderItems = (ArrayList<Order>) ois.readObject();
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

            if (fis != null) {
                try {
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return orderItems;
    }

}
