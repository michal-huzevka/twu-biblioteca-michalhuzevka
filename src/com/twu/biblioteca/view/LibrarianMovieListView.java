package com.twu.biblioteca.view;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.UserAccount;

import java.util.List;

/**
 * Created by michal on 2/23/15.
 */
public class LibrarianMovieListView implements View {
    private List<Movie> libraryItems;
    public LibrarianMovieListView(List<Movie> libraryItems) {
        this.libraryItems = libraryItems;
    }
    public String output() {
        StringBuilder builder = new StringBuilder();
        for (Movie libraryItem : libraryItems) {
            UserAccount borrower = libraryItem.getBorrower();
            String s = libraryItem.getTitle() + " is borrowed by " + borrower.getFirstName() + " " + borrower.getLastName();
            builder.append(s + "\r\n");
        }
        return  builder.toString();
    }
}
