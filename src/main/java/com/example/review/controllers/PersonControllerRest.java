package com.example.review.controllers;

import com.example.review.entities.Person;
import com.example.review.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/person")
public class PersonControllerRest {
    @Autowired
    PersonService service;

    @GetMapping("")
    public List<Person> init(){
        return service.list();
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@RequestBody Person p, @PathVariable("id") long id) {
      service.delete(id);
    }
    @GetMapping("/{id}")
    public Person get(@PathVariable("id") long id) {
        return service.getId(id);
    }
    @PostMapping
    public Long create(@RequestBody Person p){
       return service.add(p).getId();
    }

    @PutMapping("/{id}")
    public void updatebis(@RequestBody Person p, @PathVariable("id") long id){
        p.setId(id);
        service.update(p);
    }
    @PostUpdate
    public void update(@RequestBody Person p){
        Person old = service.getId(p.getId());
        if(p.getNom() != null){
            old.setNom(p.getNom());
        }
        if(p.getPrenom() != null){
            old.setPrenom(p.getPrenom());
        }
       service.update(old);
    }
}
