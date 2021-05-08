package com.example.demo.service;

import com.example.demo.exceptions.CategoryNotFoundException;
import com.example.demo.model.Category;
import com.example.demo.model.User;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CategoryService {


    CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> listAll(String sortDir, String keyword) {

        Sort sort = Sort.by("name");

        if (sortDir.equals("asc")){
            sort = sort.ascending();
        } else if (sortDir.equals("desc")){
            sort = sort.descending();
        }

        if (keyword != null) {
            return categoryRepository.listAll(sort, keyword);
        }
        return (List<Category>) categoryRepository.findAll(sort);
    }

    public List<Category> listCategoriesUsedInForm(){
        return (List<Category>) categoryRepository.findAll();
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category get(Integer id) throws CategoryNotFoundException {
        try {
            return categoryRepository.findById(id).get();
        }catch (NoSuchElementException ex) {
            throw new CategoryNotFoundException("Не найдена категория с ID: " + id);
        }
    }

    public boolean checkUnique(Integer id, String name){
        Category categoryByName = categoryRepository.getCategoryByName(name);
        if (categoryByName == null) return true;
        boolean isCreatingNew = (id==null);
        if (isCreatingNew){
            if (categoryByName != null) return false;
        } else {
            if(categoryByName.getId() != id) {
                return false;
            }
        }
        return true;
    }

    public void delete(Integer id) throws CategoryNotFoundException {
        Long countById = categoryRepository.countById(id);
        if (countById == null || countById == 0) {
            throw new CategoryNotFoundException("Категория с ID " + id + " не найдена");
        }
        categoryRepository.deleteById(id);
    }



}