package com.twu.biblioteca.view;

/**
 * Created by michal on 2/23/15.
 */
public class MenuView implements View {
        public String output() {
            StringBuilder builder = new StringBuilder();
            builder.append("Type a letter from the following list and then press enter.\r\n");
            builder.append("Q to Quit\r\n");
            builder.append("L to List available books\r\n");
            builder.append("C to Check out a book\r\n");
            builder.append("R to Return a book\r\n");
            builder.append("M to view Menu options\r\n");
            return builder.toString();
        }
}
