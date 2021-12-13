package com.example.dao;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.example.common.dao.FileDAO;

public class BillDAO implements FileDAO<byte[]> {
    private String billName;

    public BillDAO(String billName) {
        this.billName = billName;
    }

    @Override
    public void writeToDB(byte[] bytes) {
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;

        try {
            fos = new FileOutputStream(billName);
            bos = new BufferedOutputStream(fos);
            bos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public byte[] readFromDB() {
        return new byte[0];
    }
}
