package com.api.crud.controllers;

import com.api.crud.models.UserModel;
import com.api.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<UserModel> getUsers(){
        return this.userService.getUsers();
    }

    @GetMapping(path="/{id}")
    public Optional<UserModel> getUserById(@PathVariable Long id){
        return this.userService.getById(id);
    }

    @PostMapping
    public UserModel saveUser(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }

    @PutMapping(path="/{id}")
    public UserModel updateUserById(@RequestBody UserModel user, @PathVariable Long id){
        return this.userService.updateById(user, id);
    }
}
