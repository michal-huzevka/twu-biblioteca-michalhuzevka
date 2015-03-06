package com.twu.biblioteca.controller.console;

import com.twu.biblioteca.controller.general.MenuController;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.UserType;
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
            view = loginLogoutCommand();
        }
        if (toLower.equals("b")) {
            if (library.getActiveUser() != null && library.getActiveUser().getUserType() == UserType.LIBRARIAN) {
                view = controller.GetUnavailableBooks();
            } else {
                view = controller.GetAvailableBooks();
            }
        }
        if (toLower.equals("m")) {
            if (library.getActiveUser() != null && library.getActiveUser().getUserType() == UserType.LIBRARIAN) {
                view = controller.GetUnavailableMovies();
            } else {
                view = controller.GetAvailableMovies();
            }
        }
        if (library.getActiveUser() != null && library.getActiveUser().getUserType() == UserType.CUSTOMER) {
            if (toLower.equals("c")) {
                view = new GenericView("Please type in the name of the item you wish to checkout.\r\n");
                nextState = new CheckoutState(library);
            }
            if (toLower.equals("r")) {
                view = new GenericView("Please type in the name of the item you wish to return.\r\n");
                nextState = new ReturnState(library);
            }
        }

        if (toLower.equals("o")) {
            view = new MenuView(library.getActiveUser());
        }
        //default view
        if (view == null) {
            view = new GenericView("Select a valid option! Press O to view the menu options. \r\n");
        }
        return view;
    }

    private View loginLogoutCommand() {
        View view;
        if (library.getActiveUser() == null) {
            view = new GenericView("Please enter your library ID to login.\r\n");
            nextState = new EnterLibraryIDState(library);
        } else {
            library.setActiveUserID(null);
            view = new GenericView("You are now logged out. Press O to view the menu options.");
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
