package com.twu.biblioteca.model;

import com.twu.biblioteca.view.View;

/**
 * Created by michalhuzevka on 9/03/15.
 */
public class StubWriter implements IWriter {
    private View lastView;
    public void writeView(View view) {
        lastView = view;
    }

    public View getLastView() {
        return lastView;
    }
    public String getLastOutput() {
        return lastView.output();
    }
}
