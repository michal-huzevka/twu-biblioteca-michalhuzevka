package com.twu.biblioteca.unit.model;

import com.twu.biblioteca.model.Book;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by michal on 2/23/15.
 */
public class BookTest {
    @Test
    public void Should_UpdateStatus_WhenBookIsCheckedOut() throws Exception{
        Book book = new Book("Software Refactoring");
        assert(book.isAvailable());

        book.checkout();
        assert(!book.isAvailable());

    }

    @Test
    public void Should_ThrowException_IfBookIsCheckedOutTwice() throws  Exception{
        Book book = new Book("Software Refactoring");

        book.checkout();
        try {
            book.checkout();
            Assert.fail();
        } catch (Exception ex) {

        }
    }

    @Test
    public void Should_UpdateStatus_WhenBookIsReturned() throws Exception{
        Book book = new Book("Software Refactoring");
        assert(book.isAvailable());

        book.checkout();
        assert(!book.isAvailable());

        book.returnBook();
        assert (book.isAvailable());

    }

    @Test
    public void Should_ThrowException_IfBookIsIncorrectlyReturned() throws  Exception{
        Book book = new Book("Software Refactoring");

        try {
            book.returnBook();
            Assert.fail();
        } catch (Exception ex) {

        }
    }
}
