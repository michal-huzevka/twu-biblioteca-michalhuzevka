package com.twu.biblioteca.controller;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.BookListView;
import com.twu.biblioteca.view.GenericView;
import com.twu.biblioteca.view.MenuView;
import com.twu.biblioteca.view.View;

/**
 * Created by michal on 2/23/15.
 */
public class MainController {

    private boolean terminated = false;
    private Library library;
    private UserState currentState = UserState.MENU;

    private enum UserState {
        MENU,
        CHECKOUT,
        RETURN
    };

    public MainController(Library library) {

        this.library = library;
    }
    public View action(String input) {
        switch (currentState) {
            case MENU:return menuStateAction(input);
            case CHECKOUT:return checkoutStateAction(input);
            case RETURN:return returnStateAction(input);
            default: return new GenericView("Error");
        }
    }

    private View menuStateAction(String input) {
        String toLower = input.toLowerCase();
        View view = null;
        if (toLower.equals("q")) {
            view = new GenericView("");
            terminated = true;

        } else if (toLower.equals("l")) {
            view = new BookListView(library.getAvailableBooks());

        } else if (toLower.equals("c")) {
            view = new GenericView("Please type in the name of the book you wish to checkout.");
            currentState = UserState.CHECKOUT;

        } else if (toLower.equals("r")) {
            view = new GenericView("Please type in the name of the book you wish to return.");
            currentState = UserState.RETURN;
        } else if (toLower.equals("m")) {
            view = new MenuView();
            return view;
        }
        else {
            view = new GenericView("Select a valid option! Press m to view the menu options. \r\n");
        }
        return view;
    }

    private View checkoutStateAction(String input) {
        CheckoutController controller = new CheckoutController(library);
        View view = controller.checkout(input);
        if (controller.shouldReturnToMenu()) currentState = UserState.MENU;
        return view;
    }

    private View returnStateAction(String input) {
        ReturnController controller = new ReturnController(library);
        View view = controller.returnBook(input);
        if (controller.shouldReturnToMenu()) currentState = UserState.MENU;
        return view;
    }

    public boolean isTerminated() {
        return terminated;
    }
}
