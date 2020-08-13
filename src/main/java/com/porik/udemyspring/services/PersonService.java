package com.porik.udemyspring.services;

import com.porik.udemyspring.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();

    public Person create(Person person) {

        return person;
    }

    public Person update(Person person) {

        return person;
    }

    public void delete(String id) {

    }

    public Person findById(String id) {
        Person person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("Fulano");
        person.setLastName("de Tal");
        person.setAddress("São Paulo - São Paulo - Brasil");
        person.setGender("Male");

        return person;
    }

    public List<Person> findAll() {
        List<Person> personList = new ArrayList<Person>();
        for (int i = 0; i < 8; i++){
            Person person = mockPerson(i);
            personList.add(person);
        }
        return personList;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name" + i);
        person.setLastName("Last name" + i);
        person.setAddress("Some address" + i);
        person.setGender("Male");
        return person;
    }
}
