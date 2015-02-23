package com.twu.biblioteca.unit;

import com.twu.biblioteca.model.Book;
import org.junit.Test;

/**
 * Created by michal on 2/23/15.
 */
public class BookTest {
    @Test
    public void Should_UpdateStatus_WhenBookIsCheckedOut() {
        Book book = new Book("Software Refactoring");
        assert(book.isAvailable());

        book.checkout();
        assert(!book.isAvailable());

    }
}
