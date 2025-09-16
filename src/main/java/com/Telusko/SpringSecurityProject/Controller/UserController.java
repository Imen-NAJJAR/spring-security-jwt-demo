package com.Telusko.SpringSecurityProject.Controller;

import com.Telusko.SpringSecurityProject.Service.UserService;
import com.Telusko.SpringSecurityProject.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;
    @PostMapping("/register")
    public Users regiter(@RequestBody Users user ){
        return service.regiter(user);
    }

    @PostMapping("/login")
    public String verify( @RequestBody Users user ){
         return service.verify(user);
    }
}
