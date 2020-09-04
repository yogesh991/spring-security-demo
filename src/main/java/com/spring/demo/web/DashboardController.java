package com.spring.demo.web;/*
@Author : Yogesh Deshmukh
*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String getDashBoard(){
        return "dashboard";
    }
}
