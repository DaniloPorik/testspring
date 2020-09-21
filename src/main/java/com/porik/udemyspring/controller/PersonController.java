package com.porik.udemyspring.controller;

import com.porik.udemyspring.data.vo.v1.PersonVO;
import com.porik.udemyspring.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import static org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.linkTo;
//import static org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.methodOn;

//@CrossOrigin  //CORS
@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    private PersonService service;

//    @GetMapping(produces = { "application/json", "application/xml" })
//    public List<PersonVO> findAll() {
////        List<PersonVO> persons = service.findAll();
////        persons.stream()
////        .forEach(p -> p.add(
////              .linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()
////              )
////          );
////      return persons
//
//        return service.findAll();
//    }

    @GetMapping(produces = { "application/json", "application/xml" })
    public List<PersonVO> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                  @RequestParam(value = "limit", defaultValue = "12") int limit,
                                  @RequestParam(value = "direction", defaultValue = "asc") String direction) {

        var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "firstName"));

//        List<PersonVO> persons = service.findAll();
//        persons.stream()
//        .forEach(p -> p.add(
//              .linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()
//              )
//          );
//      return persons

        return service.findAll(pageable);
    }

    //@CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
    public PersonVO findById(@PathVariable("id") Long id) {
//        PersonVO personVO = service.findById(id);
//        personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return service.findById(id);
    }

    //@CrossOrigin(origins = {"http://localhost:8080", "http://www.erudio.com.br"})
    @PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" },
                    consumes = { "application/json", "application/xml", "application/x-yaml" })
    public PersonVO create(@RequestBody PersonVO person) {

        return service.create(person);
    }

    @PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" },
                    consumes = { "application/json", "application/xml", "application/x-yaml" })
    public PersonVO update(@RequestBody PersonVO person) {

        return service.update(person);
    }

    @PatchMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
    public PersonVO disablePerson(@PathVariable("id") Long id) {
        PersonVO personVO = service.disablePerson(id);
//        personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return personVO;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.ok().build();
    }

//    @GetMapping(value = "/findPersonByName/{firstName}", produces = { "application/json", "application/xml", "application/x-yaml" })
//    public ResponseEntity<?> findPersonByName(
//            @PathVariable("firstName") String firstName,
//            @RequestParam(value="page", defaultValue = "0") int page,
//            @RequestParam(value="limit", defaultValue = "12") int limit,
//            @RequestParam(value="direction", defaultValue = "asc") String direction) {
//
//        var sortDirection = "desc".equalsIgnoreCase(direction) ? Sort.Direction.DESC : Sort.Direction.ASC;
//
//        Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "firstName"));
//
//        Page<PersonVO> persons =  service.findPersonByName(firstName, pageable);
//        persons
//                .stream()
//                .forEach(p -> p.add(
//                        linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()
//                        )
//                );
//
//        PagedResources<?> resources = assembler.toResource(persons);
//
//        return new ResponseEntity<>(resources, HttpStatus.OK);
//    }

}
