package com.twu.biblioteca.controller.console;

import com.twu.biblioteca.controller.general.ReturnController;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.MenuView;
import com.twu.biblioteca.view.View;

/**
 * Created by michalhuzevka on 4/03/15.
 */
public class ReturnState extends BaseState {
    private Library library;
    private BaseState nextState;
    public ReturnState(Library library) {
        this.library = library;
        nextState = this;
    }

    public View action(String input) {
        View view = null;
        if (input.toLowerCase().equals("r")) {
            view = new MenuView();
            nextState = new MenuState(this.library);
        } else {
            ReturnController returnController = new ReturnController(library);
            view = returnController.returnItem(input);
            nextState = returnController.nextState();
        }
        return view;
    }
    public BaseState nextState() {
        return nextState;
    }
}
