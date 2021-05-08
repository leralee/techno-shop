package com.example.demo.controller;

import com.example.demo.repository.BrandRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    final
    ProductRepository productRepository;
    BrandRepository brandRepository;
    CategoryRepository categoryRepository;
    UserRepository userRepository;

    public MainController(ProductRepository productRepository, BrandRepository brandRepository
    , CategoryRepository categoryRepository, UserRepository userRepository) {
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @GetMapping()
    public String viewHomePage(Model model) {
        model.addAttribute("productCount", productRepository.count());
        model.addAttribute("brandCount", brandRepository.count());
        model.addAttribute("categoryCount", categoryRepository.count());
        model.addAttribute("userCount", userRepository.count());
        model.addAttribute("pageTitle", "Главная");
        return "index";
    }


    @GetMapping("/login")
    public String viewLoginPage(){
        return "login";
    }

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("pageTitle", "Об авторе");
        return "about";
    }

//    @GetMapping("/client")
//    public String client(){
//        return "client";
//    }


}
