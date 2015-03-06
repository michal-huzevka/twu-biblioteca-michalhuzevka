package com.twu.biblioteca;

import com.twu.biblioteca.model.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by michal on 2/23/15.
 */
public class THelper {
    public static Library initLibrary() {
        Library library = new Library();
        library.addBooks(listOfBooks());
        library.addMovies(listOfMovies());
        library.setAccountCollection(accountCollection());
        return library;
    }

    public static List<Book> listOfBooks() {
        List<Book> libraryItems = new LinkedList<Book>();

        libraryItems.add(new Book("The Agile Samurai", "Johnathon Rasmusson", "2002"));
        libraryItems.add(new Book("Software Refactoring", "Martin Fowler", "2004"));
        libraryItems.add(new Book("Design Patterns", "Gang of Four", "1996"));
        return libraryItems;
    }

    public static List<Movie> listOfMovies() {
        List<Movie> movies = new LinkedList<Movie>();
        movies.add(new Movie("Star Wars", "Steven Spielberg", "1979",  "10"));
        movies.add(new Movie("The Shawshank Redemption", "?", "1995", "10"));
        return movies;
    }

    public static AccountCollection accountCollection() {
        AccountCollection collection = new AccountCollection();
        collection.add(sampleUser());
        collection.add(sampleLibrarian());
        return collection;
    }

    public static UserAccount sampleUser() {
        return new UserAccount("1234", "asd123", "John", "Smith", "john@hotmail.com", "44445555", UserType.CUSTOMER);
    }

    public static UserAccount sampleLibrarian() {
        return new UserAccount("2222", "asd123", "Michael", "Dunphey", "michal@gmail.com", "12340000", UserType.LIBRARIAN);
    }

}
