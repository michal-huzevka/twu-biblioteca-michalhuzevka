package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by michal on 2/23/15.
 */
public class THelper {
    public static Library initLibrary() {
        return new Library(listOfBooks());
    }

    public static List<Book> listOfBooks() {
        List<Book> books = new LinkedList<Book>();

        books.add(new Book("The Agile Samurai", "Johnathon Rasmusson", "2002"));
        books.add(new Book("Software Refactoring", "Martin Fowler", "2004"));
        books.add(new Book("Design Patterns", "Gang of Four", "1996"));
        return books;
    }
}
