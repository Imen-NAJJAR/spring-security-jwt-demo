package com.Telusko.SpringSecurityProject.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String welcome(){
        return "this ower secure api that's whay you have to log in !";
    }
}
