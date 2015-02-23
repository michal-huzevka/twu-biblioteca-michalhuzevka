package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by michal on 2/23/15.
 */
public class Library {
    private List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<Book>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public Book getBookByTitle(String title) {
        String lower = title.toLowerCase();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().equals(lower)) {
                return book;
            }
        }
        throw new NoSuchElementException();
    }

    public void checkoutBook(Book book) {
        book.checkout();
    }
}
