package gg.service.api;

import com.fasterxml.jackson.databind.util.JSONPObject;
import gg.domain.Book;
import gg.domain.BookDto;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Vyacheslav Predantsev on 01.10.2015
 */
public interface RequestService {

    public Iterable<BookDto> books(HttpServletRequest request);

    public JSONPObject JsonpBooks(HttpServletRequest request);

    public Book book(int id, HttpServletRequest request);

    public JSONPObject JsonpBook(int id, HttpServletRequest request);
}
