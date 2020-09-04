package com.spring.demo.security;/* 
@Author : Yogesh Deshmukh
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth
//                .inMemoryAuthentication()
//                .passwordEncoder(passwordEncoder)
//                .withUser("user")
//                .password("$2a$10$MwdE0pCQZmCQXAOEEkXxPeEEGuvJ1I3Ux0NGFhUq3R8QW1GVh0eja")
//                .roles("USER","ADMIN");
//    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .userDetailsService(userDetailService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
      //          .csrf().disable()   --when you enable csrf, you need to pass the token value at login page
                .authorizeRequests()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .anyRequest().hasAnyRole("USER").and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/dashboard")
                .permitAll();
    }
}
