package gg;

import gg.domain.Book;
import gg.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GgApplication {

    public static void main(String[] args) {
        SpringApplication.run(GgApplication.class, args);
    }

    @Bean
    public CommandLineRunner repo(BookRepository repository) {
        return (args) -> {
            repository.save(new Book("Arthur Conan Doyle", "Stories of Sherlock Holmes", "/images/10654849", 125.00));
            repository.save(new Book("Arthur Conan Doyle","The Lost World", "/images/12687469", 75.25));
            repository.save(new Book("Jack London", "The Call of the Wild", "/images/16878416", 70.50));
            repository.save(new Book("Jack London", "Martin Eden", "/images/15674898", 100.75));
            repository.save(new Book("William Shakespeare", "Sonnets", "/images/14584165", 50.25));
        };
    }
}
