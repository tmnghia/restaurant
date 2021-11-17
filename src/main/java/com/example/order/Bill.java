package com.example.order;

public class Bill {
    private String id;
    private String billName;
    private Order order;
    private BillDAO dao;

    public Bill(String id, Order order) {
        this.id = id;
        this.order = order;
        this.billName = "bill_" + this.id + ".csv";
        dao = new BillDAO(billName);
    }

    public void exportToCSV() {
        byte[] bytes = order.toString().getBytes();
        dao.writeToDB(bytes);
    }
}
