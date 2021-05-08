package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

//    @Query("SELECT p FROM Product p WHERE p.nameProduct LIKE %?1% "
//    + "OR p.brand LIKE %?1%")
//    Page<Product> findAll(String keyword, Pageable pageable);

    Product findByName(String name);

    public Long countById(Integer id);
}
