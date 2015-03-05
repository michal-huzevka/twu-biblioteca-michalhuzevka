package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by michal on 2/23/15.
 */
public class Library {
    private List<LibraryItem> libraryItems;
    private List<Movie> movies;

    public Library() {
        libraryItems = new ArrayList<LibraryItem>();
        movies = new ArrayList<Movie>();
    }

    /*
    public Library(List<LibraryItem> libraryItems) {
        this.libraryItems = libraryItems;
    }
*/
    public List<LibraryItem> getAvailableBooks() {
        List<LibraryItem> availableLibraryItems = new ArrayList<LibraryItem>();
        for (LibraryItem libraryItem : libraryItems) {
            if (libraryItem.isAvailable()) {
                availableLibraryItems.add(libraryItem);
            }
        }
        return availableLibraryItems;
    }

    public LibraryItem getBookByTitle(String title) {
        String lower = title.toLowerCase();
        for (LibraryItem libraryItem : libraryItems) {
            if (libraryItem.getTitle().toLowerCase().equals(lower)) {
                return libraryItem;
            }
        }
        throw new NoSuchElementException();
    }

    public void checkoutBook(LibraryItem libraryItem) throws Exception {
        libraryItem.checkout();
    }

    public List<Movie> getAvailableMovies() {
        List<Movie> availableMovies = new ArrayList<Movie>();
        for (Movie movie : movies) {
            if (movie.isAvailable()) {
                availableMovies.add(movie);
            }
        }
        return availableMovies;
    }

    public void addMovies(List<Movie> newMovies) {
        movies.addAll(newMovies);
    }

    public void addMovie(Movie newMovie) {
        movies.add(newMovie);
    }

    public void addBooks(List<LibraryItem> books) {
        libraryItems.addAll(books);
    }


}
