package com.mandiri.orderservice.model;

import javax.persistence.*;
import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class orderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "orderid")
    private String orderid;

    @Column(name = "nama")
    private String nama;

    @Column(name = "orderdate")
    private String orderdate;

    @Column(name = "address")
    private String address;

    @Column(name = "productitem")
    private String productitem;

    public orderModel() {

    }
    public orderModel(String orderid, String nama, String orderdate, String address, String productitem) {
        this.orderid = orderid;
        this.nama = nama;
        this.orderdate = orderdate;
        this.address = address;
        this.productitem = productitem;
    }

//    public long getId() {
//        return id;
//    }
//
//    public String getOrderid() {
//        return orderid;
//    }
//
//    public void setOrderid(String orderid) {
//        this.orderid = orderid;
//    }
//
//    public String getNama() {
//        return nama;
//    }
//
//    public void setNama(String nama) {
//        this.nama = nama;
//    }
//
//    public Date getOrderdate() {
//        return orderdate;
//    }
//
//    public void setOrderDate(Date orderdate) {
//        this.orderdate = orderdate;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getProductitem() {
//        return productitem;
//    }
//
//    public void setProductitem(String productitem) {
//        this.productitem = productitem;
//    }

    @Override
    public String toString() {
        return "Order [id=" + orderid + ", Name=" + nama + ", Date order=" + orderdate + ", Address=" + address + ", Product Item=" + productitem + "]";
    }
}
