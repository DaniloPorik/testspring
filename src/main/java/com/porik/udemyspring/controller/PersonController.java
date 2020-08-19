package com.porik.udemyspring.controller;

import com.porik.udemyspring.model.Person;
import com.porik.udemyspring.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") Long id) {

        return service.findById(id);
    }

    @GetMapping
    public List<Person> findAll() {

        return service.findAll();
    }

    @PostMapping
    public Person create(@RequestBody Person person) {

        return service.create(person);
    }

    @PutMapping
    public Person update(@RequestBody Person person) {

        return service.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.ok().build();
    }

}
