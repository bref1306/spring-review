package com.example.review;

import com.example.review.classes.Hello;
import com.example.review.entities.Person;
import com.example.review.repositories.PersonRepository;
import com.example.review.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ReviewApplication implements CommandLineRunner {
    @Autowired
    private PersonService personService;
    @Autowired
    PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(ReviewApplication.class, args);
    }
    private void print(Object val){
        System.out.println("#" + val );
    }
    private void list(){
        List<Person> list = (List)personRepository.findAll();
        for (Person p:list){
            print(p);
        }
    }

    @Override
    public void run(String... args) throws Exception {
        list();
    }
}
