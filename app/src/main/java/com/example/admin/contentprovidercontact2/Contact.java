package com.example.admin.contentprovidercontact2;

import java.io.Serializable;

public class Contact implements Serializable {

    String ten;
    String soDienThoai;


    public Contact(String ten, String soDienThoai) {
        this.ten = ten;
        this.soDienThoai = soDienThoai;
    }


    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
}
