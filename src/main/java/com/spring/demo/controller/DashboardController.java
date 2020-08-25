package com.spring.demo.controller;/* 
@Author : Yogesh Deshmukh
*/

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    @GetMapping("/dashboard")
    public String getDashBoard(){
        return "dashboard";
    }
}
