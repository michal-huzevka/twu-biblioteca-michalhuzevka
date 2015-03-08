package com.twu.biblioteca.model;

import com.twu.biblioteca.view.View;

/**
 * Created by michalhuzevka on 9/03/15.
 */
public class ConsoleWriter implements IWriter {
    public void writeView(View view) {
        System.out.print(view.output());
    }
}
