package cgg.spring.com.springsecurity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import  cgg.spring.com.springsecurity.model.User;

@Service
public class UserService {
    
    private List<User> users=new ArrayList<>();

    public UserService(){
        users.add(new User("Sindhu","1234","sindhu@gmail.com"));
        users.add(new User("abc","123","abc@gmail.com"));
    }

    public List<User> getAllUsers(){
        return this.users;
    }

    public User getUser(String userName){
        return users.stream().filter(user->user.getUserName().equals(userName)).findAny().orElse(null);
    }

    public User createUser(User user){
         this.users.add(user);
         return user;
    }
}
