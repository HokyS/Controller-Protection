package com.example.ControllerProtection.controllers;

import com.example.ControllerProtection.entities.Roles;
import com.example.ControllerProtection.entities.User;
import com.example.ControllerProtection.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@PreAuthorize("hasRole('"+ Roles.ADMIN +"') OR returnObject.body == null OR returnObject.body.createdBy.id == authentication.principal.id")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public List<User> getAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public void getSingle(@PathVariable Long id){
        userService.findById(id);
    }

    @PostMapping()
    public void createUser(@RequestBody User user){
        userService.save(user);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,@RequestBody User user){
        user.setId(id);
        userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteSingle(@PathVariable Long id, @RequestBody User user){
        userService.deleteById(id);
    }

    @DeleteMapping()
    public void deleteAll(){
        userService.deleteAll();
    }
}
