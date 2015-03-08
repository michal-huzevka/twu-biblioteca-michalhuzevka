package com.twu.biblioteca.model;

import java.util.Scanner;

/**
 * Created by michalhuzevka on 9/03/15.
 */
public class StubReader implements  IReader {
    private String fakeInput = "";
    public String readLine() {

        return fakeInput;
    }

    public void addFakeInput(String input) {
        fakeInput = input;
    }
}
