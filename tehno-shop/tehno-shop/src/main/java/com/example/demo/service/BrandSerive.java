package com.example.demo.service;

import com.example.demo.exceptions.BrandNotFoundException;
import com.example.demo.model.Brand;
import com.example.demo.model.Category;
import com.example.demo.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BrandSerive {

    BrandRepository brandRepository;

    @Autowired
    public BrandSerive(BrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }

    public List<Brand> findAll() {
        return (List<Brand>) brandRepository.findAll();
    }

    public List<Brand> listAll(String sortDir, String keyword) {
        Sort sort = Sort.by("name");

        if (sortDir.equals("asc")){
            sort = sort.ascending();
        } else if (sortDir.equals("desc")){
            sort = sort.descending();
        }

        if (keyword != null) {
            return brandRepository.listAll(sort, keyword);
        }
        return (List<Brand>) brandRepository.findAll(sort);
    }

    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }

    public Brand get(Integer id) throws BrandNotFoundException {
        try {
            return brandRepository.findById(id).get();
        }catch (NoSuchElementException ex) {
            throw new BrandNotFoundException("Не найден бренд с ID: " + id);
        }
    }

    public void delete(Integer id) throws BrandNotFoundException {
        Long countById = brandRepository.countById(id);

        if (countById == null || countById == 0) {
            throw new BrandNotFoundException("Бренд с ID " + id + " не найдена");
        }

        brandRepository.deleteById(id);
    }

    public String checkUnique(Integer id, String name){
        boolean isCreatingNew = (id == null || id == 0);
        Brand brandByName = brandRepository.findByName(name);

        if (isCreatingNew) {
            if (brandByName != null) return "Duplicate";
        } else {
            if (brandByName != null && brandByName.getId() != id) {
                return "Duplicate";
            }
        }
        return "OK";
    }
}
