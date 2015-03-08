package com.twu.biblioteca;

import com.twu.biblioteca.controller.console.ConsoleController;
import com.twu.biblioteca.model.*;
import com.twu.biblioteca.view.GenericView;
import com.twu.biblioteca.view.MenuView;
import com.twu.biblioteca.view.View;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
TODO:
X Refactor controllers so they are split into two: one for handling console input and one for performing actions
Add in unit tests for each state
X Create an item class that Book inherits from
X Ability to check out an item rather than a book
X Movies should have a name, year, director and movie rating (from 1-10 or unrated)
X List Movies
X Checkout Movie
Book must be checked out to a user
Users must login to checkout and return books
Predefined user credentials
View user account information

Hamcrust
Mockito
EasyMock
 */
public class BibliotecaApp {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Library library = initDefaultLibrary();
        ConsoleController controller = new ConsoleController(library, reader, writer);

        View intro = new GenericView("Welcome to Biblioteca! Please feel free to view our books.");
        MenuView menu = new MenuView(library.getActiveUser());
        writer.writeView(intro);
        writer.writeView(menu);

        while (!controller.isTerminated()) {
            controller.nextAction();
        }
    }


    private static Library initDefaultLibrary() {
        List<Book> books = new LinkedList<Book>();
        books.add(new Book("A Game of Thrones", "George R. R. Martin", "1996"));
        books.add(new Book("Frankenstein", "Mary Shelley", "1883"));
        books.add(new Book("Siddhartha", "Hermann Hesse", "1922"));
        books.add(new Book("Nausea", "Jean-Paul Sartre", "1938"));
        books.add(new Book("The Stranger", "Albert Camus", "1942"));
        books.add(new Book("Out", "Natsuo Kirino", "2004"));

        List<Movie> movies = new LinkedList<Movie>();
        movies.add(new Movie("Pan's Labyrinth", "Guillermo del Toro", "2006", "10"));
        movies.add(new Movie("The Shawshank Redemption", "Frank Darabont", "1994", "10" ));

        Library library = new Library();
        library.addBooks(books);
        library.addMovies(movies);
        AccountCollection collection = library.getAccountCollection();
        collection.add(new UserAccount("0000", "asd123", "John", "Smith", "a@hotmail.com", "12341234", UserType.CUSTOMER));
        collection.add(new UserAccount("1111", "asd123", "John", "Washington", "b@hotmail.com", "", UserType.CUSTOMER));
        collection.add(new UserAccount("2222", "asd123", "Jack", "Johnson", "", "", UserType.LIBRARIAN));
        return library;
    }
}
