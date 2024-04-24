package cgg.spring.com.springsecurity.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cgg.spring.com.springsecurity.model.User;
import cgg.spring.com.springsecurity.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    
    private  UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<User> getAllUsers(){
        return this.service.getAllUsers();
    }
    
    @GetMapping("/{userName}")
    public User getSingleUser(@PathVariable String userName){
        return this.service.getUser(userName);
    }

    @PostMapping("/")
    public User createUser(User user){
        return this.service.createUser(user);
    }
}
