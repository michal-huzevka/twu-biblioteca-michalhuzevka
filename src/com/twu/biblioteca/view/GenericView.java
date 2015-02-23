package com.twu.biblioteca.view;

/**
 * Created by michal on 2/23/15.
 */
public class GenericView implements View {
    String output;
    public GenericView(String output) {
        this.output = output;
    }
    public String output() {
        return output;
    }
}
