package com.redis.com.redis.controllers;

import com.redis.com.redis.entities.jpa.UserJPA;
import com.redis.com.redis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public List<UserJPA> get(){
        return userService.get();
    }

    @PostMapping("/")
    public void post(@RequestBody UserJPA user){
        userService.post(user);
    }

    @PutMapping("/{id}")
    public void update(String id, UserJPA user){
        userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(String id){
        userService.delete(id);
    }

}
