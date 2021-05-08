package com.example.demo.restController;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @Autowired
    private UserService service;

    @PostMapping("/users/check_username")
    public String checkDuplicateUsername(@Param("id") Integer id, @Param("username") String username){
        return service.isUsernameUnique(id, username) ? "OK" : "Duplicate";
    }
}
