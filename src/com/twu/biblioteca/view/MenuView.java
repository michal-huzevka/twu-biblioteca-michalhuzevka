package com.twu.biblioteca.view;

/**
 * Created by michal on 2/23/15.
 */
public class MenuView implements View {
        public String output() {
            StringBuilder builder = new StringBuilder();
            builder.append("Type a letter from the following list and then press enter.\r\n");
            builder.append("B to list available Books\r\n");
            builder.append("M to list available Movies\r\n");
            builder.append("C to Check out an item\r\n");
            builder.append("R to Return an item\r\n");
            builder.append("O to view menu Options\r\n");
            builder.append("Q to Quit\r\n");
            return builder.toString();
        }
}
