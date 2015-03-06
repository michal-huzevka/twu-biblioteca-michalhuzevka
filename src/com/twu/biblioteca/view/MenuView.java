package com.twu.biblioteca.view;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.twu.biblioteca.model.UserAccount;
import com.twu.biblioteca.model.UserType;

/**
 * Created by michal on 2/23/15.
 */
public class MenuView implements View {
    private UserAccount userAccount;

    public MenuView(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public String output() {
        if (userAccount == null) {
            return outputForNotLoggedInUser();
        }
        else if (userAccount.getUserType() == UserType.CUSTOMER) {
            return outputForCustomer();
        } else if (userAccount.getUserType() == UserType.LIBRARIAN) {
            return outputForLibrarian();
        }
        return "";
    }

    private String outputForCustomer() {
        StringBuilder builder = new StringBuilder();
        builder.append("Type a letter from the following list and then press enter.\r\n");
        builder.append("L to logout\r\n");
        builder.append("B to list available Books\r\n");
        builder.append("M to list available Movies\r\n");
        builder.append("C to Check out an item\r\n");
        builder.append("R to Return an item\r\n");
        builder.append("O to view menu Options\r\n");
        builder.append("Q to Quit\r\n");
        return builder.toString();
    }
    private String outputForLibrarian() {
        StringBuilder builder = new StringBuilder();
        builder.append("Type a letter from the following list and then press enter.\r\n");
        builder.append("L to logout\r\n");
        builder.append("B to list borrowed Books\r\n");
        builder.append("M to list borrowed Movies\r\n");
        builder.append("O to view menu Options\r\n");
        builder.append("Q to Quit\r\n");
        return builder.toString();
    }
    private String outputForNotLoggedInUser() {
        StringBuilder builder = new StringBuilder();
        builder.append("Type a letter from the following list and then press enter.\r\n");
        builder.append("L to Login\r\n");
        builder.append("B to list available Books\r\n");
        builder.append("M to list available Movies\r\n");
        builder.append("O to view menu Options\r\n");
        builder.append("Q to Quit\r\n");
        return builder.toString();
    }
}
