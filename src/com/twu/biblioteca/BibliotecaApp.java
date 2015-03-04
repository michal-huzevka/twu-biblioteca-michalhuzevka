package com.twu.biblioteca;

import com.twu.biblioteca.controller.console.ConsoleController;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.MenuView;
import com.twu.biblioteca.view.View;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
TODO:
Refactor controllers so they are split into two: one for handling console input and one for performing actions
Create an item class that Book inherits from
Ability to check out an item rather than a book
Movies should have a name, year, director and movie rating (from 1-10 or unrated)
List Movies
Checkout Movie
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
        System.out.println("Welcome to Biblioteca! Please feel free to view our books.");
        Library library = initDefaultLibrary();
       // MainController controller = new MainController(library);
        ConsoleController controller = new ConsoleController(library);
        MenuView menu = new MenuView();
        displayView(menu);

        while (!controller.isTerminated()) {
            String input = getUserInput();
            View view = controller.action(input);
            displayView(view);
        }
    }

    private static void displayView(View view) {
        System.out.print(view.output());
    }

    private static String getUserInput() {
        return in.nextLine();
    }

    private static Library initDefaultLibrary() {
        List<Book> books = new LinkedList<Book>();
        books.add(new Book("A Game of Thrones", "George R. R. Martin", "1996"));
        books.add(new Book("Frankenstein", "Mary Shelley", "1883"));
        books.add(new Book("Siddhartha", "Hermann Hesse", "1922"));
        books.add(new Book("Nausea", "Jean-Paul Sartre", "1938"));
        books.add(new Book("The Stranger", "Albert Camus", "1942"));
        books.add(new Book("Out", "Natsuo Kirino", "2004"));
        return new Library(books);
    }
}
