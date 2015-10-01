package gg.service.impl;

import com.fasterxml.jackson.databind.util.JSONPObject;
import gg.domain.Book;
import gg.domain.BookDto;
import gg.repository.BookRepository;
import gg.service.api.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vyacheslav Predantsev on 01.10.2015
 */
@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    BookRepository repository;

    @Override
    public Iterable<BookDto> books(HttpServletRequest request) {
        List<BookDto> books = convertBooksToDtos((List<Book>) repository.findAll());
        String offsetParam = request.getParameter("offset");
        String countParam = request.getParameter("count");
        Integer offset = offsetParam != null ? Integer.valueOf(offsetParam) : null;
        Integer count = countParam != null ? Integer.valueOf(countParam) : null;
        if (offset != null && offset <= books.size()) {
            int size = books.size();
            books = books.subList(offset, size);
        }
        if (count != null && count <= books.size()) {
            books = books.subList(0, count);
        }
        return books;
    }

    private List<BookDto> convertBooksToDtos(List<Book> books) {
        List<BookDto> dtos = new ArrayList<>();
        for (Book book: books) {
            dtos.add(new BookDto(book.getId(), "/api/v1/items/" + book.getId(), book.getTitle()));
        }
        return dtos;
    }

    @Override
    public JSONPObject JsonpBooks(HttpServletRequest request) {
        return new JSONPObject(request.getParameter("callback"), books(request));
    }

    @Override
    public Book book(int id, HttpServletRequest request) {
        return repository.findOne(id);
    }

    @Override
    public JSONPObject JsonpBook(int id, HttpServletRequest request) {
        return new JSONPObject(request.getParameter("callback"), repository.findOne(id));
    }
}
