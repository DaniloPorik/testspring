package com.porik.udemyspring.services;

import com.porik.udemyspring.converter.DozerConverter;
import com.porik.udemyspring.data.vo.v1.PersonVO;
import com.porik.udemyspring.exception.ResourceNotFoundException;
import com.porik.udemyspring.data.model.Person;
import com.porik.udemyspring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    //a variavel "var" faz com que o JAVA ja compreenda qual é o tipo

    public PersonVO create(PersonVO person) {
        //Person
        var entity = DozerConverter.parseObject(person, Person.class);
        //PersonVO
        var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);

        return vo;
    }

    public List<PersonVO> findAll() {
        return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        return DozerConverter.parseObject(entity, PersonVO.class);
    }

    public PersonVO update(PersonVO p) {
        //Person
        var entity = repository.findById(p.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(p.getFirstName());
        entity.setLastName(p.getLastName());
        entity.setAddress(p.getAddress());
        entity.setGender(p.getGender());

        //PersonVO
        var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public void delete(Long id) {
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        repository.delete(entity);
    }





}
