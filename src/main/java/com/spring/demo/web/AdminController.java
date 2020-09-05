package com.spring.demo.web;/* 
@Author : Yogesh Deshmukh
*/

import com.spring.demo.model.User;
import com.spring.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/admin")
    public String getDashBoard(@AuthenticationPrincipal User user, ModelMap map){
        System.out.println(user);
        map.put("user",user);
        List<User> allUsers = adminService.getAllUsers();
        map.put("users",allUsers);

        return "admin";
    }
}
