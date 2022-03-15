package com.example.review.controllers;

import com.example.review.entities.Person;
import com.example.review.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PersonController {
    @Autowired
    private PersonService service;

    @GetMapping("/")
    public String init(Model model){
        List<Person> ps = service.list();
        model.addAttribute("persons", ps);
        return "list_person";
    }

    @GetMapping("/{id}")
    public String init(Model model, @PathVariable("id") long id){
        Person ps = service.getId(id);
        model.addAttribute("person", ps);
        return "person";
    }

    @GetMapping("/form")
    public String initCreate(Model model){
        Person p = new Person("", "");
        model.addAttribute("personne", p);
        return "form_create";
    }

    @GetMapping("/form/create")
    public String create(Person p, Model model){
        service.add(p);
        return "redirect:/";
    }
}
