package com.example.ymldemo.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UserResource {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/all")
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @PostMapping("/load")
    public List<User> persist(@RequestBody final User user){
        userRepository.save(user);
        return userRepository.findAll();
    }

}
