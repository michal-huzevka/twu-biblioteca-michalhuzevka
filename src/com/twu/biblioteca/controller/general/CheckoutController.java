package com.twu.biblioteca.controller.general;

import com.twu.biblioteca.controller.console.BaseState;
import com.twu.biblioteca.controller.console.CheckoutState;
import com.twu.biblioteca.controller.console.MenuState;
import com.twu.biblioteca.model.LibraryItem;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.UserAccount;
import com.twu.biblioteca.view.GenericView;
import com.twu.biblioteca.view.View;

/**
 * Created by michalhuzevka on 5/03/15.
 */
public class CheckoutController {
    private Library library;
    private BaseState nextState = null;
    public CheckoutController(Library library) {
        this.library = library;
    }

    public View checkout(String title) {
        View view = null;
        try {
            boolean bookExists = library.bookExists(title);
            String userID = library.getActiveUserID();
            LibraryItem item = null;
            if (bookExists) {
                item = library.getBookByTitle(title);
            } else {
                item = library.getMovieByTitle(title);
            }
            library.checkoutItem(item, userID);
            view = new GenericView("Thank you! Enjoy the item.\r\n");
            nextState = new MenuState(this.library);
        } catch (Exception ex) {
            view = new GenericView("That item is not available. Please try again or type in R to return to the menu.\r\n");
            nextState = new CheckoutState(this.library);
        }
        return view;
    }
    public BaseState nextState() {
        return nextState;
    }
}
