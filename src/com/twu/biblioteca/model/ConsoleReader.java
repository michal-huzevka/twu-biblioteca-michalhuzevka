package com.twu.biblioteca.model;

import java.util.Scanner;

/**
 * Created by michalhuzevka on 9/03/15.
 */
public class ConsoleReader implements Reader {
    private Scanner in = new Scanner(System.in);
    public String readLine() {
        return in.nextLine();
    }
}
