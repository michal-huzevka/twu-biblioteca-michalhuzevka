package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.GenericView;
import com.twu.biblioteca.view.View;

import java.util.NoSuchElementException;

/**
 * Created by michal on 2/23/15.
 */
public class ReturnController {
    private Library library;
    public ReturnController(Library library) {
        this.library = library;
    }

    public View checkout(String title) {
        View view = null;
        try {
            Book book = library.getBookByTitle(title);
            book.checkout();
            view = new GenericView("Thank you! Enjoy the book.");
        }
        catch (NoSuchElementException ex) {
            view = new GenericView("That book is not available.");
        }
        catch (Exception ex) {
            view = new GenericView("That book is not available.");
        }
        return view;
    }
}
