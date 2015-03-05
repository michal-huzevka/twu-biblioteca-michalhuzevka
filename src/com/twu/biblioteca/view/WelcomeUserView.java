package com.twu.biblioteca.view;

import com.twu.biblioteca.model.LibraryItem;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.UserAccount;

import java.util.List;

/**
 * Created by michal on 2/23/15.
 */
public class WelcomeUserView implements View {
    private UserAccount account;
    public WelcomeUserView(UserAccount account) {
        this.account = account;
    }
    public String output() {
        String s = "You have successfully logged in. Welcome, " + account.getFirstName() + " " + account.getLastName() + "!";
        return  s;
    }
}
