package com.twu.biblioteca.integration;

//import build.tools.javazic.Main;
import com.twu.biblioteca.THelper;
import com.twu.biblioteca.controller.console.*;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import org.junit.Test;

/**
 * Created by michal on 2/23/15.
 */
public class CheckoutAndReturnTest {
    @Test
    public void CheckOutAndReturn1() {
        Library library = THelper.initLibrary();
        assert(library.getAvailableBooks().size() == 3);

        CheckoutState checkoutState = new CheckoutState(library);
        String book1 = "Design Patterns";
        String book2 = "Software Refactoring";
        checkoutState.action(book1);
        assert (library.getAvailableBooks().size() == 2);

        checkoutState.action(book2);
        assert (library.getAvailableBooks().size() == 1);

        checkoutState.action("asdfga not a book");
        assert (library.getAvailableBooks().size() == 1);


        ReturnState returnState = new ReturnState(library);
        returnState.action(book1);
        assert (library.getAvailableBooks().size() == 2);

        returnState.action(book2);
        assert (library.getAvailableBooks().size() == 3);

        returnState.action("asdfga not a book");
        assert (library.getAvailableBooks().size() == 3);
    }

    @Test
    public void CheckOutAndReturn2() {
        Library library = THelper.initLibrary();
        ConsoleController controller = new ConsoleController(library);
        Book book = library.getBookByTitle("Design Patterns");
        assert (book.isAvailable());
        assert (library.getAvailableBooks().size() == 3);
        controller.action("c");
        controller.action("Design Patterns");
        controller.action("Not a command");

        assert (library.getAvailableBooks().size() == 2);
        assert (!book.isAvailable());
        controller.action("c");
        controller.action("r");
        controller.action("r");
        controller.action("Test book");
        controller.action("Design Patterns");
        assert (library.getAvailableBooks().size() == 3);
        assert (book.isAvailable());
        controller.action("r");
        controller.action("Design Patterns");
        assert (library.getAvailableBooks().size() == 3);
        assert (book.isAvailable());


    }
}
