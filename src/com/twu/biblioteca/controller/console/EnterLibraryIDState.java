package com.twu.biblioteca.controller.console;

import com.twu.biblioteca.controller.general.ReturnController;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.GenericView;
import com.twu.biblioteca.view.MenuView;
import com.twu.biblioteca.view.View;

/**
 * Created by michalhuzevka on 5/03/15.
 */
public class EnterLibraryIDState extends BaseState {
    private Library library;
    private BaseState nextState;
    public EnterLibraryIDState(Library library) {
        this.library = library;
        nextState = this;
    }

    public View action(String input) {
        View view = new GenericView("Please enter your password");
        nextState = new EnterPasswordState(library, input);
        return view;
    }
    public BaseState nextState() {
        return nextState;
    }
}
