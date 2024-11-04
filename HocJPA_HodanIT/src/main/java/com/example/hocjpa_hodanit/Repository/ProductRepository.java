package com.example.hocjpa_hodanit.Repository;

import com.example.hocjpa_hodanit.Entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products,Integer>, JpaSpecificationExecutor<Products> {

    Products findById(int id);//Xem chi tiet 1 san pham
    List<Products> findAllByFactory(String name);//Tim kiem theo hang san xuat

}
