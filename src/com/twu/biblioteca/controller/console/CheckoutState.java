package com.twu.biblioteca.controller.console;

import com.twu.biblioteca.controller.general.CheckoutController;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.GenericView;
import com.twu.biblioteca.view.MenuView;
import com.twu.biblioteca.view.View;

/**
 * Created by michalhuzevka on 4/03/15.
 */
public class CheckoutState extends BaseState {
    private Library library;
    private BaseState nextState;
    public CheckoutState(Library library) {
        this.library = library;
        nextState = this;
    }

    public View action(String input) {
        View view = null;
        if (input.toLowerCase().equals("r")) {
            view = new MenuView();
            nextState = new MenuState(this.library);
        } else {
            CheckoutController controller = new CheckoutController(library);
            view = controller.checkout(input);
            nextState = controller.nextState();
        }
        return view;
    }
    public BaseState nextState() {
        return nextState;
    }
}
