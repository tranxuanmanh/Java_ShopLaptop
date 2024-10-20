package com.example.hocjpa_hodanit.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="order_details")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    private double price;

    //order_id
    @ManyToOne()
    @JoinColumn(name="order_id",referencedColumnName = "id")
    private Orders order;
    //product_id
    @ManyToOne
    @JoinColumn(name="product_id",referencedColumnName = "id")
    private Products product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public OrderDetails() {
    }

    public OrderDetails(int id, int quantity, double price, Orders order, Products product) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.order = order;
        this.product = product;
    }
}
