package com.twu.biblioteca.model;

/**
 * Created by michalhuzevka on 5/03/15.
 */
public class Book extends LibraryItem {
    public Book(String title) {
        super(title);
    }

    public Book(String title, String author, String yearPublished) {
        super(title, author, yearPublished);
    }
}
