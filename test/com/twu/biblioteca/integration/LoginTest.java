package com.twu.biblioteca.integration;

import com.twu.biblioteca.controller.console.MenuState;
import com.twu.biblioteca.model.StubReader;
import com.twu.biblioteca.model.StubWriter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import com.twu.biblioteca.THelper;
import com.twu.biblioteca.controller.console.ConsoleController;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.View;



/**
 * Created by michal on 2/23/15.
 */
public class LoginTest {
    private Library library;
    private StubReader reader;
    private StubWriter writer;
    private ConsoleController controller;

    @Before
    public void setUp() {
        library = THelper.initLibrary();
        reader = new StubReader();
        writer = new StubWriter();
        controller = new ConsoleController(library,reader, writer);
    }

    @Test
    public void loginTest1() {
        View view = null;

        assertTrue (library.getActiveUserID() == null);
        view = fakeInput("l");
        assertThat(view.output(), containsString("Please enter your library ID to login"));
        view = fakeInput("1234");

        assertThat(view.output(), containsString("Please enter your password"));
        view = fakeInput("asd123");
        assertThat(view.output(), containsString("You have successfully logged in. Welcome, John Smith!"));

        assertTrue(library.getActiveUserID().equals("1234"));
        assertTrue(library.getActiveUser().getID().equals("1234"));

        view = fakeInput("l");
        assertThat(view.output(), containsString("You are now logged out"));
        assertTrue(library.getActiveUserID() == null);
    }

    public View fakeInput(String input) {
        reader.addFakeInput(input);
        controller.nextAction();
        return writer.getLastView();
    }

}
