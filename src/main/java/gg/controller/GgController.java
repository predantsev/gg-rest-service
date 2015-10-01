package gg.controller;

import gg.domain.Book;
import gg.domain.BookDto;
import gg.repository.BookRepository;
import gg.service.api.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * User: predantsev
 * Date: 30.09.2015
 * Time: 23:19
 */
@RestController
@RequestMapping(value = "/api/v1")
public class GgController {

    @Autowired
    RequestService service;

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public Object all(HttpServletRequest request) {
        if (request.getParameter("callback") != null) {
            return service.JsonpBooks(request);
        }
        return service.books(request);
    }

    @RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
    public Object book(@PathVariable("id") int id, HttpServletRequest request) {
        if (request.getParameter("callback") != null) {
            return service.JsonpBook(id, request);
        }
        return service.book(id, request);
    }
}
