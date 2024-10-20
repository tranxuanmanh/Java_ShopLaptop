package com.example.hocjpa_hodanit.Service;

import com.example.hocjpa_hodanit.Entity.Products;

import java.util.List;

public interface ProductService {
    List<Products> getAllProduct();//Tra ve danh sach san pham
    Products getProductById(int id);//Tra ve 1 san pham

    Products save(Products products);//Luu 1 san pham
    void deleteProductById(int id);//Xoa 1 san pham

    void updateProductById(int id);//Update 1 san pham
}
