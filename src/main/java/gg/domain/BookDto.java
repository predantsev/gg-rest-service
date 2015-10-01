package gg.domain;

/**
 * Created by Vyacheslav Predantsev on 01.10.2015
 */
public class BookDto {

    private int id;

    private String bookPath;

    private String title;

    //-- constructors

    public BookDto(int id, String bookPath, String title) {
        this.id = id;
        this.bookPath = bookPath;
        this.title = title;
    }

    //-- getters & setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookPath() {
        return bookPath;
    }

    public void setBookPath(String bookPath) {
        this.bookPath = bookPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
