package com.example.demo.repository;

import com.example.demo.model.Category;
import com.example.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {

    @Query("SELECT c FROM Category c WHERE c.name LIKE %?1%")
    List<Category> listAll(Sort sort, String keyword);


    Long countById(Integer id);

    Category findByName(String name);

    @Query("SELECT c FROM Category c WHERE c.name = :name")
    Category getCategoryByName(@Param("name") String name);


}
