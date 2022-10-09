package com.mandiri.orderservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String id;
    private String nama;
    private Integer price;
    private Integer qty;

    public Product() {

    }
    public Product(String id, String nama, Integer price, Integer qty) {
        this.id = id;
        this.nama = nama;
        this.price = price;
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Product [Id=" + id + ", Name=" + nama + ", Price=" + price + ", Quantity=" + qty + "]";
    }
}
