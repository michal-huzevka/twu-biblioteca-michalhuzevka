package com.twu.biblioteca.controller.console;

import com.twu.biblioteca.model.Reader;
import com.twu.biblioteca.model.Writer;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.View;

/**
 * Created by michalhuzevka on 4/03/15.
 */
public class ConsoleController
{
    private BaseState currentState;
    private Library library;
    private Reader reader;
    private Writer writer;

    public ConsoleController(Library library, Reader reader, Writer writer) {
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
