package com.twu.biblioteca.controller.general;

import com.twu.biblioteca.controller.console.*;
import com.twu.biblioteca.model.LibraryItem;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.GenericView;
import com.twu.biblioteca.view.View;

/**
 * Created by michalhuzevka on 5/03/15.
 */
public class ReturnController {
    private Library library;
    private BaseState nextState = null;
    public ReturnController(Library library) {
        this.library = library;
    }

    public View returnItem(String title) {
        View view = null;
        try {
            boolean bookExists = library.bookExists(title);
            if (bookExists) {
                library.getBookByTitle(title).returnItem();
            } else {
                library.getMovieByTitle(title).returnItem();
            }
            view = new GenericView("Thank you for returning the item.\r\n");
            nextState = new MenuState(this.library);
        } catch (Exception ex) {
            view = new GenericView("That is not a valid item to return. Please try again or type in R to return to the menu.\r\n");
            nextState = new ReturnState(this.library);
        }
        return view;
    }
    public BaseState nextState() {
        return nextState;
    }
}
