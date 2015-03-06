package com.twu.biblioteca.unit.controller.general;

import com.twu.biblioteca.THelper;
import com.twu.biblioteca.controller.console.MenuState;
import com.twu.biblioteca.controller.general.MenuController;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.BookListView;
import com.twu.biblioteca.view.LibrarianBookListView;
import com.twu.biblioteca.view.View;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by michal on 2/23/15.
 */
public class MenuControllerTest {

    private Library library;
    private MenuController menuController;
    @Before
    public void setUp() {
        library = THelper.initLibrary();
        menuController = new MenuController(library);
    }
//dont need any tests here yet, all the functions are one liners
}
