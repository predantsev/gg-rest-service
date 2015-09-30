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
            repository.save(new Book("A", "AA", "img/16545", 50.25d));
            repository.save(new Book("B", "BB", "img/16498", 150.00d));
            repository.save(new Book("C", "CC", "img/16187", 100.75d));
            repository.save(new Book("D", "DD", "img/16587", 75.50d));
        };
    }
}
