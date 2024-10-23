package com.example.hocjpa_hodanit.Service;

import com.example.hocjpa_hodanit.Entity.Products;
import com.example.hocjpa_hodanit.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    //List product
    @Override
    public List<Products> getAllProduct() {
        return productRepository.findAll();
    }
    //Lay 1 san pham theo id
    @Override
    public Products getProductById(int id) {
        return productRepository.findById(id);
    }
    //Luu 1 san pham
    @Override
    public Products save(Products products) {
        return productRepository.save(products);
    }
    //Xoa 1 san pham
    @Override
    public void deleteProductById(int id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public List<Products> getProductByName(String name) {
        return this.productRepository.findAllByFactory(name);
    }
}
