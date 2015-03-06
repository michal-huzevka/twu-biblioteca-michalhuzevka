package com.twu.biblioteca.unit.view;

import com.twu.biblioteca.THelper;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.UserAccount;
import com.twu.biblioteca.view.BookListView;
import com.twu.biblioteca.view.LibrarianBookListView;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by michalhuzevka on 6/03/15.
 */
public class LibrarianBookListViewTest {

    @Test
    public void Output_ShouldDisplayListOfBooks() throws Exception {
        Library library = THelper.initLibrary();
        UserAccount sampleUser = THelper.sampleUser();
        List<Book> books = library.getAvailableBooks();
        for (Book book : books) {
            library.checkoutItem(book, sampleUser.getID());
        }

        LibrarianBookListView view = new LibrarianBookListView(books);
        String output = view.output();
        assertTrue(output.contains("The Agile Samurai"));
        assertTrue(output.contains("Software Refactoring"));
        assertTrue(output.contains("Design Patterns"));
        assertTrue(output.contains(sampleUser.getFirstName()));
        assertTrue(output.contains(sampleUser.getLastName()));

    }
}
