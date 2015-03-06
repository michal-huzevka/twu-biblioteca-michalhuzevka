package com.twu.biblioteca.unit.controller.console;

import com.twu.biblioteca.THelper;
import com.twu.biblioteca.controller.console.ConsoleController;
import com.twu.biblioteca.controller.console.MenuState;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.BookListView;
import com.twu.biblioteca.view.LibrarianBookListView;
import com.twu.biblioteca.view.View;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.*;

/**
 * Created by michal on 2/23/15.
 */
public class MenuStateTest {

    private Library library;
    private MenuState menuState;
    @Before
    public void setUp() {
        library = THelper.initLibrary();
        menuState = new MenuState(library);
    }

    @Test
    public void Should_Terminate_When_QIsPressed() {
        menuState.action("q");
        assertTrue(menuState.isTerminated());
    }

    @Test
    public void Should_ShowAvailableBooks_When_LIsPressedAndUserIsNotLibrarian() {
        View view = menuState.action("b");
        assertTrue(view instanceof BookListView);
    }

    @Test
    public void Should_ShowUnavailableBooks_When_LIsPressedAndUserIsLibrarian() {
        library.setActiveUserID(THelper.sampleLibrarian().getID());
        View view = menuState.action("b");
        assertTrue(view instanceof LibrarianBookListView);
    }
}
