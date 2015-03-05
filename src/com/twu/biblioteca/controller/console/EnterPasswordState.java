package com.twu.biblioteca.controller.console;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.UserAccount;
import com.twu.biblioteca.view.GenericView;
import com.twu.biblioteca.view.View;
import com.twu.biblioteca.view.WelcomeUserView;

import java.util.NoSuchElementException;

/**
 * Created by michalhuzevka on 5/03/15.
 */
public class EnterPasswordState extends BaseState {
    private Library library;
    private BaseState nextState;
    private String libraryID;
    public EnterPasswordState(Library library, String libraryID) {
        this.library = library;
        nextState = this;
        this.libraryID = libraryID;
    }

    public View action(String input) {
        View view = null;
        nextState = new MenuState(library);
        try {
            UserAccount account = library.getAccountCollection().getUser(libraryID, input);
            library.setActiveUserID(account.getID());
            view = new WelcomeUserView(account);
        } catch (NoSuchElementException ex) {
            view = new GenericView("That username and password combination doesn't match. You are moved back to the main menu now.\r\n");

        }

        return view;
    }
    public BaseState nextState() {
        return nextState;
    }
}
