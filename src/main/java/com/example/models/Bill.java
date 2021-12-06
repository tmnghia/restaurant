package com.example.models;

import com.example.dao.BillDAO;

public class Bill {
    private String id;
    private String billName;
    private Order order;

    public Bill(String id, Order order) {
        this.id = id;
        this.order = order;
        this.billName = "bill_" + this.id + ".csv";
    }

    public void exportToCSV() {
        BillDAO dao = new BillDAO(billName);
        byte[] bytes = order.toString().getBytes();
        dao.writeToDB(bytes);
    }
}
