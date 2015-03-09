package com.twu.biblioteca.integration;

//import build.tools.javazic.Main;
import com.twu.biblioteca.THelper;
import com.twu.biblioteca.controller.console.*;
import com.twu.biblioteca.model.*;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by michal on 2/23/15.
 */
public class CheckoutAndReturnTest {
    private Library library;
    private StubReader reader;
    private StubWriter writer;
    private ConsoleController controller;

    @Test
    public void checkOutAndReturn1() {
        Library library = THelper.initLibrary();
        UserAccount user = THelper.sampleUser();
        library.setActiveUserID(user.getID());

        assertTrue(library.getAvailableBooks().size() == 3);

        CheckoutState checkoutState = new CheckoutState(library);
        String book1 = "Design Patterns";
        String book2 = "Software Refactoring";
        checkoutState.action(book1);
        assertTrue (library.getAvailableBooks().size() == 2);

        checkoutState.action(book2);
        assertTrue (library.getAvailableBooks().size() == 1);

        checkoutState.action("asdfga not a book");
        assertTrue (library.getAvailableBooks().size() == 1);


        ReturnState returnState = new ReturnState(library);
        returnState.action(book1);
        assertTrue (library.getAvailableBooks().size() == 2);

        returnState.action(book2);
        assertTrue (library.getAvailableBooks().size() == 3);

        returnState.action("asdfga not a book");
        assertTrue (library.getAvailableBooks().size() == 3);
    }

    @Test
    public void checkOutAndReturn2() {
        library = THelper.initLibrary();
        reader = new StubReader();
        writer = new StubWriter();
        controller = new ConsoleController(library,reader, writer);

        LibraryItem libraryItem = library.getBookByTitle("Design Patterns");
        assertTrue (libraryItem.isAvailable());
        assertTrue (library.getAvailableBooks().size() == 3);

        fakeInput("l");
        fakeInput("1234");
        fakeInput("asd123");
        fakeInput("c");
        fakeInput("Design Patterns");
        fakeInput("Not a command");

        assertTrue (library.getAvailableBooks().size() == 2);
        assertTrue (!libraryItem.isAvailable());
        fakeInput("c");
        fakeInput("r");
        fakeInput("r");
        fakeInput("Test book");
        fakeInput("Design Patterns");
        assertTrue (library.getAvailableBooks().size() == 3);
        assertTrue (libraryItem.isAvailable());
        fakeInput("r");
        fakeInput("Design Patterns");
        assertTrue (library.getAvailableBooks().size() == 3);
        assertTrue (libraryItem.isAvailable());
    }

    public void fakeInput(String input) {
        reader.addFakeInput(input);
        controller.nextAction();
    }
}
