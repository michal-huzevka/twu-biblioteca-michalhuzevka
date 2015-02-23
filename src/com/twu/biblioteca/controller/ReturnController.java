package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.GenericView;
import com.twu.biblioteca.view.MenuView;
import com.twu.biblioteca.view.View;

import java.util.NoSuchElementException;

/**
 * Created by michal on 2/23/15.
 */
public class ReturnController {
    private Library library;
    private boolean returnToMenu = false;
    public ReturnController(Library library) {

        this.library = library;
    }

    public View returnBook(String title) {
        View view = null;
        if (title.toLowerCase().equals("r")) {
            view = new MenuView();
            returnToMenu = true;
        } else {
            try {
                Book book = library.getBookByTitle(title);
                book.returnBook();
                view = new GenericView("Thank you for returning the book.\r\n");
                returnToMenu = true;
            } catch (Exception ex) {
                view = new GenericView("That is not a valid book to return. Please try again or type in R to return to the menu.\r\n");
                returnToMenu = false;
            }
        }
        return view;
    }

    public boolean shouldReturnToMenu() {
        return returnToMenu;
    }
}
