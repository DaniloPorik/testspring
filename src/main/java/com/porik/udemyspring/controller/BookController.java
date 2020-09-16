package com.porik.udemyspring.controller;

import java.util.List;

import com.porik.udemyspring.data.vo.v1.BookVO;
import com.porik.udemyspring.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Api(tags = "BookEndpoint")  SWAGGER
@RestController
@RequestMapping("/api/book/v1")
public class BookController<BookServices> {

    @Autowired
    private BookService service;

    //@ApiOperation(value = "Find all books" )
    @GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
    public List<BookVO> findAll() {
//        List<BookVO> books =  service.findAll();
//        books
//                .stream()
//                .forEach(p -> p.add(
//                        linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel()
//                        )
//                );
//        return books;
        return service.findAll();
    }

    //@ApiOperation(value = "Find a specific book by your ID" )  SWAGGER
    @GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
    public BookVO findById(@PathVariable("id") Long id) {
//        BookVO bookVO = service.findById(id);
//        bookVO.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
//        return bookVO;
        return service.findById(id);
    }

    //@ApiOperation(value = "Create a new book")  SWAGGER
    @PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" },
            consumes = { "application/json", "application/xml", "application/x-yaml" })
    public BookVO create(@RequestBody BookVO book) {
//        BookVO bookVO = service.create(book);
//        bookVO.add(linkTo(methodOn(BookController.class).findById(bookVO.getKey())).withSelfRel());
//        return bookVO;
        return service.create(book);
    }

    //@ApiOperation(value = "Update a specific book")   SWAGGER
    @PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" },
            consumes = { "application/json", "application/xml", "application/x-yaml" })
    public BookVO update(@RequestBody BookVO book) {
//        BookVO bookVO = service.update(book);
//        bookVO.add(linkTo(methodOn(BookController.class).findById(bookVO.getKey())).withSelfRel());
//        return bookVO;
        return service.update(book);
    }

    //@ApiOperation(value = "Delete a specific book by your ID")  SWAGGER
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
