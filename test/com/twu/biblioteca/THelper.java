package com.twu.biblioteca;

import com.twu.biblioteca.model.LibraryItem;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Movie;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by michal on 2/23/15.
 */
public class THelper {
    public static Library initLibrary() {
        Library library = new Library();
        library.addBooks(listOfBooks());
        return library;
    }

    public static List<LibraryItem> listOfBooks() {
        List<LibraryItem> libraryItems = new LinkedList<LibraryItem>();

        libraryItems.add(new LibraryItem("The Agile Samurai", "Johnathon Rasmusson", "2002"));
        libraryItems.add(new LibraryItem("Software Refactoring", "Martin Fowler", "2004"));
        libraryItems.add(new LibraryItem("Design Patterns", "Gang of Four", "1996"));
        return libraryItems;
    }

    public static List<Movie> listOfMovies() {
        List<Movie> movies = new LinkedList<Movie>();
        movies.add(new Movie("'Star Wars"));
        movies.add(new Movie("The Shawshank Redemption"));
        return movies;
    }
}
