package com.twu.biblioteca.controller.console;

import com.twu.biblioteca.view.View;

/**
 * Created by michalhuzevka on 4/03/15.
 */
public abstract class BaseState {
    public abstract View action(String input);
    public abstract BaseState nextState();

}
