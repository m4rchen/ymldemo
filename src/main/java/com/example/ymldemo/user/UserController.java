package com.example.ymldemo.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/hello")
    @ResponseBody
    public String getHello(){
        return "Hello World";
    }

    @GetMapping(value = "/all")
    @ResponseBody
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping(value = "/page")
    public String getPage(){
        return "page";
    }

}
