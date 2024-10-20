package com.example.hocjpa_hodanit.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Khong duoc de trong ")
    @Size(min=5,message="Toi thieu 5 ki tu")
    private String name;
    @NotNull(message = "Khong duoc de trong")
    @DecimalMin(value = "0",inclusive = false,message = "Price phai lon hon 0")
    private double price;
    private String image;
    @NotEmpty(message = "Khong duoc de trong detail")
    @Column(columnDefinition = "MEDIUMTEXT")
    private String detailDesc;
    @NotEmpty(message = "Khong duoc de trong shortDetail")
    private String shortDesc;
    @Min(value = 2,message = "So luong nho nhat la 2")
    private int quantity;
    private int sold;
    private String factory;
    private String target;

    //CategoryId

    public Products() {
    }

    public Products(int id, String name, double price, String image, String detailDesc, String shortDesc, int quantity, int sold, String factory, String target) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.detailDesc = detailDesc;
        this.shortDesc = shortDesc;
        this.quantity = quantity;
        this.sold = sold;
        this.factory = factory;
        this.target = target;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
