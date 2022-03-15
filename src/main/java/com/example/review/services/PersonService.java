package com.example.review.services;

import com.example.review.entities.Person;
import com.example.review.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class PersonService {
    @Autowired
    PersonRepository repo;
    public List<Person> list(){
        return (List<Person>)repo.findAll();
    }
    public void delete(Long id){
       repo.deleteById(id);
    }
    public Person add(Person p){
        repo.save(p);
        return p;
    }
    public Person getId(Long id){
        Optional<Person> o = repo.findById(id);
        if(!o.isPresent()){
            throw new RuntimeException("Id inconnu("+id+")");
        }
        return o.get();
    }
    public Person update(Person p){
        return repo.save(p);
    }

}
