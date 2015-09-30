package gg.controller;

import gg.domain.Book;
import gg.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: predantsev
 * Date: 30.09.2015
 * Time: 23:19
 */
@RestController
public class GgController {

    @Autowired
    BookRepository repository;

    @RequestMapping(value = "/items/all", method = RequestMethod.GET)
    public Iterable<Book> all() {
        return repository.findAll();
    }

    @RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
    public Book hello(@PathVariable("id") int id) {
        return repository.findOne(id);
    }
}
