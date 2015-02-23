package com.twu.biblioteca;
import com.twu.biblioteca.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by michal on 2/23/15.
 */
public class LibraryTest {

    @Test
    public void Should_ListAvailableBooks_When_BooksAreAdded() {
        List<Book> initialList = listOfBooks();
        Library library = new Library(initialList);

        List<Book> availableBooks = library.getAvailableBooks();
        assert(availableBooks.containsAll(initialList));

    }

    @Test
    public void Should_RemoveBook_When_BookIsCheckedOut() {
        Library library = initLibrary();

        Book book = library.getBookByTitle("The Agile Samurai");
        library.checkoutBook(book);
        List<Book> availableBooks = library.getAvailableBooks();
        for (Book tmpBook : availableBooks) {
            assert(tmpBook != book);
        }
    }

    @Test
    public void GetBookByTitle_Should_ReturnBook() {
        Library library = initLibrary();
        Book book = library.getBookByTitle("The Agile Samurai");
        assert (book.getTitle().equals("The Agile Samurai"));
    }

    @Test
    public void GetBookByTitle_Should_ThrowException_When_NoBooksExist() {
        Library library = initLibrary();
        try {
            Book book = library.getBookByTitle("Test book");
            Assert.fail("Exception not thrown");

        }
        catch (NoSuchElementException e) {

        }
    }

    private Library initLibrary() {
        return new Library(listOfBooks());
    }

    private List<Book> listOfBooks() {
        List<Book> books = new LinkedList<Book>();
        books.add(new Book("The Agile Samurai"));
        books.add(new Book("Software Refactoring"));
        books.add(new Book("Design Patterns"));
        return books;
    }
}
