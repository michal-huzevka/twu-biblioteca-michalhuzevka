package com.twu.biblioteca.model;

/**
 * Created by michalhuzevka on 5/03/15.
 */
public class Book extends LibraryItem {
    private String author;

    public Book(String title, String author, String yearPublished) {
        super(title, yearPublished);
        setAuthor(author);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String toString() {
        return getTitle() + " by " + getAuthor() + " in " + getYearCreated();
    }
}
