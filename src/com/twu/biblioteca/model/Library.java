package com.twu.biblioteca.model;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by michal on 2/23/15.
 */
public class Library {
    private List<Book> books;
    private List<Movie> movies;
    private AccountCollection accountCollection;

    public Library() {
        books = new ArrayList<Book>();
        movies = new ArrayList<Movie>();
        setAccountCollection(new AccountCollection());
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableLibraryItems = new ArrayList<Book>();
        for (Book libraryItem : books) {
            if (libraryItem.isAvailable()) {
                availableLibraryItems.add(libraryItem);
            }
        }
        return availableLibraryItems;
    }

    public Book getBookByTitle(String title) {
        String lower = title.toLowerCase();
        for (Book libraryItem : books) {
            if (libraryItem.getTitle().toLowerCase().equals(lower)) {
                return libraryItem;
            }
        }
        throw new NoSuchElementException();
    }

    public Movie getMovieByTitle(String title) {
        String lower = title.toLowerCase();
        for (Movie libraryItem : movies) {
            if (libraryItem.getTitle().toLowerCase().equals(lower)) {
                return libraryItem;
            }
        }
        throw new NoSuchElementException();
    }



    public void checkoutItem(LibraryItem libraryItem) throws Exception {
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

    public void addBooks(List<Book> newBooks) {
        books.addAll(newBooks);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean bookExists(String title) {
        return checkIfItemExists(title, books);
    }

    public boolean movieExists(String title) {
        return checkIfItemExists(title, movies);
    }

    private boolean checkIfItemExists(String title, List list) {
        String lower = title.toLowerCase();
        for (Object obj : list) {
            LibraryItem item = (LibraryItem)obj;
            if (item.getTitle().toLowerCase().equals(lower)) {
                return true;
            }
        }
        return false;
    }


    public AccountCollection getAccountCollection() {
        return accountCollection;
    }

    public void setAccountCollection(AccountCollection accountCollection) {
        this.accountCollection = accountCollection;
    }
}
