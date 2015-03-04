package com.twu.biblioteca.controller.console;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.View;

/**
 * Created by michalhuzevka on 4/03/15.
 */
public class ConsoleController
{
    private BaseState currentState;
    private Library library;

    public ConsoleController(Library library) {
        this.library = library;
        currentState = new MenuState(library);
    }

    public View action(String input) {
        View view = currentState.action(input);
        currentState = currentState.nextState();
        return view;
    }

    public boolean isTerminated() {
        if (currentState instanceof MenuState) {
            return ((MenuState) currentState).isTerminated();
        }
        return false;
    }
}
