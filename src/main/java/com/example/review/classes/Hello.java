package com.example.review.classes;

import org.springframework.stereotype.Service;

@Service
public class Hello {
    public String hello(String name){
        return "Bonjour je m'apelle " + name;
    }
}
