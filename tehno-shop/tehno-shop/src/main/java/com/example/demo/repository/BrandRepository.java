package com.example.demo.repository;

import com.example.demo.model.Brand;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BrandRepository extends PagingAndSortingRepository<Brand, Integer> {

    Long countById(Integer id);

    Brand findByName(String name);

    @Query("SELECT b FROM Brand b WHERE b.name LIKE %?1%")
    public List<Brand> listAll(Sort sort, String keyword);

//    @Query("SELECT New Brand(b.id, b.name) FROM Brand b ORDER BY b.name ASC")
//    public List<Brand> findAll();

}
