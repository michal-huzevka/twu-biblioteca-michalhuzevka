package com.twu.biblioteca.integration;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import com.twu.biblioteca.THelper;
import com.twu.biblioteca.controller.console.CheckoutState;
import com.twu.biblioteca.controller.console.ConsoleController;
import com.twu.biblioteca.controller.console.ReturnState;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.LibraryItem;
import com.twu.biblioteca.view.View;



/**
 * Created by michal on 2/23/15.
 */
public class LoginTest {
    @Test
    public void loginTest1() {
        Library library = THelper.initLibrary();
        View view = null;

        assertTrue (library.getActiveUserID() == null);
        ConsoleController controller = new ConsoleController(library);
        view = controller.action("l");
        assertThat(view.output(), containsString("Please enter your library ID to login"));
        view = controller.action("1234");

        assertThat(view.output(), containsString("Please enter your password"));
        view = controller.action("asd123");
        assertThat(view.output(), containsString("You have successfully logged in. Welcome, John Smith!"));

        assertTrue(library.getActiveUserID().equals("1234"));
        assertTrue(library.getActiveUser().getID().equals("1234"));

        view = controller.action("l");
        assertThat(view.output(), containsString("You are now logged out"));
        assertTrue(library.getActiveUserID() == null);
    }

}
