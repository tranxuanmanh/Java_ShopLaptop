package com.example.hocjpa_hodanit.Repository;

import com.example.hocjpa_hodanit.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products,Integer> {

    Products findById(int id);//Xem chi tiet 1 san pham
}
