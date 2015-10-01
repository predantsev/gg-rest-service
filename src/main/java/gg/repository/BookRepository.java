package gg.repository;

import gg.domain.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * User: predantsev
 * Date: 30.09.2015
 * Time: 23:45
 */
public interface BookRepository extends CrudRepository<Book, Integer> {

}
