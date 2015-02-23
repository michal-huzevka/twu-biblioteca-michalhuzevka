package com.twu.biblioteca;

import com.twu.biblioteca.controller.MainController;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.MenuView;
import com.twu.biblioteca.view.View;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Biblioteca! Please feel free to view our books.");
        Library library = initDefaultLibrary();
        MainController controller = new MainController(library);
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
        books.add(new Book("Cloud Computing", "Jack Henderson", "2004"));
        books.add(new Book(".NET Domain Driven Design", "Tim McCarthy", "2003"));
        books.add(new Book("Frankenstein", "Mary Shelley", "183"));
        return new Library(books);
    }
}
