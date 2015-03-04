package com.twu.biblioteca.controller.console;

import com.twu.biblioteca.controller.general.MenuController;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.BookListView;
import com.twu.biblioteca.view.GenericView;
import com.twu.biblioteca.view.MenuView;
import com.twu.biblioteca.view.View;

/**
 * Created by michalhuzevka on 4/03/15.
 */
public class MenuState extends BaseState {
    private Library library;
    private MenuController controller;
    private BaseState nextState;
    private boolean terminated;

    public MenuState(Library library) {
        terminated = false;
        this.library = library;
        nextState = this;
    }


    public View action(String input) {
        this.controller = new MenuController(library);
        String toLower = input.toLowerCase();
        View view = null;
        if (toLower.equals("q")) {
            view = new GenericView("");
            terminated = true;

        } else if (toLower.equals("l")) {
            view = controller.GetAvailableBooks();

        } else if (toLower.equals("c")) {
            view = new GenericView("Please type in the name of the book you wish to checkout.");
            nextState = new CheckoutState(library);

        } else if (toLower.equals("r")) {
            view = new GenericView("Please type in the name of the book you wish to return.");
            nextState = new ReturnState(library);
        } else if (toLower.equals("m")) {
            view = new MenuView();
            return view;
        }
        else {
            view = new GenericView("Select a valid option! Press m to view the menu options. \r\n");
        }
        return view;
    }

    public boolean isTerminated() {
        return terminated;
    }
    public BaseState nextState() {
        return nextState;
    }
}
