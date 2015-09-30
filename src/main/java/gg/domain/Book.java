package gg.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * User: predantsev
 * Date: 30.09.2015
 * Time: 23:25
 */
@Entity
public class Book {

    @Id
    @GeneratedValue
    private int id;

    private String author;

    private String title;

    private String imagePath;

    private double price;

    //-- constructors

    public Book() {
    }

    public Book(String author, String title, String imagePath, double price) {
        this.author = author;
        this.title = title;
        this.imagePath = imagePath;
        this.price = price;
    }

    //-- getters & setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
