package com.twu.biblioteca.unit.controller.console;

import com.twu.biblioteca.THelper;
import com.twu.biblioteca.controller.console.ConsoleController;
import com.twu.biblioteca.controller.console.MenuState;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.*;
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
    public void should_Terminate_When_QIsPressed() {
        menuState.action("q");
        assertTrue(menuState.isTerminated());
    }

    @Test
    public void should_ShowAvailableBooks_When_LIsPressedAndUserIsNotLibrarian() {
        View view = menuState.action("b");
        assertTrue(view instanceof BookListView);
    }

    @Test
    public void should_ShowUnavailableBooks_When_LIsPressedAndUserIsLibrarian() {
        library.setActiveUserID(THelper.sampleLibrarian().getID());
        View view = menuState.action("b");
        assertTrue(view instanceof LibrarianBookListView);
    }

    @Test
    public void should_ShowAvailableMovies_When_MIsPressedAndUserIsNotLibrarian() {
        View view = menuState.action("m");
        assertTrue(view instanceof MovieListView);
    }

    @Test
    public void should_ShowUnavailableMovies_When_MIsPressedAndUserIsLibrarian() {
        library.setActiveUserID(THelper.sampleLibrarian().getID());
        View view = menuState.action("m");
        assertTrue(view instanceof LibrarianMovieListView);
    }

    @Test
    public void should_ShowUserDetails_When_UIsPressedAsACustomer() {
        library.setActiveUserID(THelper.sampleUser().getID());
        View view = menuState.action("u");
        assertTrue(view instanceof UserDetailsView);
    }

    @Test
    public void should_NotShowUserDetails_When_UIsPressedAndUserIsNotACustomer() {
        View view = menuState.action("u");
        assertFalse(view instanceof UserDetailsView);
    }
}
