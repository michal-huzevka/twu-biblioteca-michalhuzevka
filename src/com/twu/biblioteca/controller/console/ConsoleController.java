package com.twu.biblioteca.controller.console;

import com.twu.biblioteca.model.IReader;
import com.twu.biblioteca.model.IWriter;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.View;

/**
 * Created by michalhuzevka on 4/03/15.
 */
public class ConsoleController
{
    private BaseState currentState;
    private Library library;
    private IReader reader;
    private IWriter writer;

    public ConsoleController(Library library, IReader reader, IWriter writer) {
        this.library = library;
        currentState = new MenuState(library);
        this.reader = reader;
        this.writer = writer;
    }

    public void nextAction() {
        String input = reader.readLine();
        View view = currentState.action(input);
        currentState = currentState.nextState();
        writer.writeView(view);
    }


    public boolean isTerminated() {
        if (currentState instanceof MenuState) {
            return ((MenuState) currentState).isTerminated();
        }
        return false;
    }
}
