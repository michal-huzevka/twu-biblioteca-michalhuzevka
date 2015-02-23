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
public class CheckoutController {
    private Library library;
    private boolean returnToMenu = false;
    public CheckoutController(Library library) {
        this.library = library;
    }

    public View checkout(String title) {
        View view = null;
        if (title.toLowerCase().equals("r")) {
            view = new MenuView();
            returnToMenu = true;
        } else {
            try {
                Book book = library.getBookByTitle(title);
                book.checkout();
                view = new GenericView("Thank you! Enjoy the book.\r\n");
                returnToMenu = true;
            } catch (Exception ex) {
                returnToMenu = false;
                view = new GenericView("That book is not available. Please try again or type in R to return to the menu.\r\n");
            }
        }
        return view;
    }

    public boolean shouldReturnToMenu() {
        return returnToMenu;
    }
}
