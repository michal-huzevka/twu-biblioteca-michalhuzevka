package com.twu.biblioteca.view;

/**
 * Created by michal on 2/23/15.
 */
public class BookListView implements View {
    String output;
    public BookListView(String output) {
        this.output = output;
    }
    public String output() {
        return output;
    }
}
