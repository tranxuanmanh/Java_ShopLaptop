package com.example.hocjpa_hodanit.Service;

import com.example.hocjpa_hodanit.Entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ProductService {
    List<Products> getAllProduct();//Tra ve danh sach san pham
    Products getProductById(int id);//Tra ve 1 san pham

    Products save(Products products);//Luu 1 san pham
    void deleteProductById(int id);//Xoa 1 san pham
   Specification<Products> nameLike(String name);
   Page<Products> pageProduct(String name, Pageable pageable);
  List<Products> getProductByName(String name);//Tim kiem theo hang san xuat
}
