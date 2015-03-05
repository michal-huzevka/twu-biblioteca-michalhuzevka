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
        }
        if (toLower.equals("l")) {
            view = new GenericView("Please enter your library ID");
            nextState = new EnterLibraryIDState(library);
        }
        if (toLower.equals("b")) {
            view = controller.GetAvailableBooks();
        }
        if (toLower.equals("m")) {
            view = controller.GetAvailableMovies();
        }
        if (toLower.equals("c")) {
            view = new GenericView("Please type in the name of the item you wish to checkout.");
            nextState = new CheckoutState(library);
        }
        if (toLower.equals("r")) {
            view = new GenericView("Please type in the name of the item you wish to return.");
            nextState = new ReturnState(library);
        }
        if (toLower.equals("o")) {
            view = new MenuView();
        }
        //default view
        if (view == null) {
            view = new GenericView("Select a valid option! Press O to view the menu options. \r\n");
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
