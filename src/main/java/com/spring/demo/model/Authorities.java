package com.spring.demo.model;/* 
@Author : Yogesh Deshmukh
*/

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
public class Authorities implements GrantedAuthority {

    private static  final long serialVersionUID = 1L;
    private Long id;
    private String authority;
    private User user;

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
