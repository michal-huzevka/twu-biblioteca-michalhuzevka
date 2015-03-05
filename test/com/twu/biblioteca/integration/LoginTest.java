package com.twu.biblioteca.integration;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

import com.twu.biblioteca.THelper;
import com.twu.biblioteca.controller.console.CheckoutState;
import com.twu.biblioteca.controller.console.ConsoleController;
import com.twu.biblioteca.controller.console.ReturnState;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.LibraryItem;
import com.twu.biblioteca.view.View;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by michal on 2/23/15.
 */
public class LoginTest {
    @Test
    public void LoginTest1() {
        Library library = THelper.initLibrary();
        View view = null;

        ConsoleController controller = new ConsoleController(library);
        view = controller.action("l");
        assertThat(view.output(), containsString("Please enter your library ID"));
        view = controller.action("1234");

        assertThat(view.output(), containsString("Please enter your password"));
        view = controller.action("asd123");
        assertThat(view.output(), containsString("You have successfully logged in. Welcome, John Smith!"));

        /*
        LibraryItem libraryItem = library.getBookByTitle("Design Patterns");
        assert (libraryItem.isAvailable());
        assert (library.getAvailableBooks().size() == 3);
        controller.action("c");
        controller.action("Design Patterns");
        controller.action("Not a command");

        assert (library.getAvailableBooks().size() == 2);
        assert (!libraryItem.isAvailable());
        controller.action("c");
        controller.action("r");
        controller.action("r");
        controller.action("Test book");
        controller.action("Design Patterns");
        assert (library.getAvailableBooks().size() == 3);
        assert (libraryItem.isAvailable());
        controller.action("r");
        controller.action("Design Patterns");
        assert (library.getAvailableBooks().size() == 3);
        assert (libraryItem.isAvailable());
        */
    }

}
