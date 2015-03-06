package com.twu.biblioteca.controller.general;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.BookListView;
import com.twu.biblioteca.view.LibrarianBookListView;
import com.twu.biblioteca.view.MovieListView;
import com.twu.biblioteca.view.View;

/**
 * Created by michalhuzevka on 4/03/15.
 */
public class MenuController {
    private Library library;
    public MenuController(Library library) {
        this.library = library;
    }
    public View GetAvailableBooks() {
        return new BookListView(library.getAvailableBooks());
    }

    public View GetUnavailableBooks() {
        return new LibrarianBookListView(library.getUnavailableBooks());
    }

    public View GetAvailableMovies() {
        return new MovieListView(library.getAvailableMovies());
    }
}
