package com.spring.demo;/* 
@Author : Yogesh Deshmukh
*/

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordGeneratorTest {

    @Test
    public void passwordEncryptTest(){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode("password123");
        System.out.println(encodedPassword);
    }
}
